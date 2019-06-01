package chatLab.client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

import chatLab.commons.ChatMsg;
import chatLab.commons.JoinMsg;
import chatLab.commons.Message;
import javafx.beans.property.SimpleStringProperty;

public class Model {
	
	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	private Socket socket;
	private String name;
	private Logger logger = Logger.getLogger("");
	
	public void connect(String ipAddress, int port, String name) {
		logger.info("Connect");
		this.name = name;
		try {
			socket = new Socket(ipAddress, port);
			
			Runnable r = new Runnable() {
				@Override
				public void run() {
					while(true) {
						ChatMsg msg = (ChatMsg) Message.receive(socket);
						newestMessage.set("");
						newestMessage.set(msg.getName()+": "+msg.getContent());
					}	
				}
			};
			Thread t = new Thread(r);
			t.start();
			
			Message msg = new JoinMsg(name);
			msg.send(socket);
			
		} catch(Exception e) {
			logger.warning(e.toString());
		}
	}
	
	public void disconnect() {
		logger.info("Disconnect");
		
		if(socket != null)
			try {
				socket.close();
			}catch(IOException e) {
				
			}
	}
	
	public void sendMessage(String message) {
		logger.info("Send message");
		Message msg = new ChatMsg(name, message);
		msg.send(socket);
	}
	
	public String receiveMessage() {
		logger.info("Receive Message");
		return newestMessage.get();
	}
}
