package chatLab.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import chatLab.commons.ChatMsg;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	
	protected ServerSocket listener;
	protected ObservableList<Client> clients = 
			FXCollections.observableArrayList();
	private Logger logger = Logger.getLogger("");
	private volatile boolean stop = false;
	
	public void startServer(int port) {
		logger.info("Star server");
		try {
			listener = new ServerSocket(port, 10, null);
			Runnable r = new Runnable() {
				@Override
				public void run() {
					while(!stop) {
						try {
							Socket socket = listener.accept();
							Client client = new Client(Model.this, socket);
							clients.add(client);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			Thread t = new Thread(r, "ServerSocket");
			t.start();		
				
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		for(Client c : clients) c.stop();
		logger.info("Stop server");
		
		stop = true;
		if(listener != null) {
			try {
				listener.close();
			} catch(IOException e) {
				
			}
		}
	}
	
	public ObservableList<Client> getClientList(){
		logger.info("Get client list");
		return clients;
	}

	public void broadcast(ChatMsg outMsg) {
		logger.info("Boreadcasting message to clients");
		for(Client c : clients) {
			c.send(outMsg);
		}
		
	}
}
