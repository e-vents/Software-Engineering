package chatLab.client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;

public class ClientModel {
	
	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	private Socket socket;
	private Logger logger = Logger.getLogger("");
	
	public void connect(String ipAddress, int port, String name) {
		logger.info("Connect");
		
		try {
			socket = new Socket(ipAddress, port);
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
	}
	
	public String receiveMessage() {
		logger.info("Receive Message");
		return newestMessage.get();
	}
}
