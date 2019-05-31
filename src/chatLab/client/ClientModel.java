package chatLab.client;

import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;

public class ClientModel {
	
	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	
	private Logger logger = Logger.getLogger("");
	
	public void connect(String ipAddress, int port, String name) {
		logger.info("Connect");
	}
	
	public void disconnect() {
		logger.info("Disconnect");
	}
	
	public void sendMessage(String message) {
		logger.info("Send message");
	}
	
	public String receiveMessage() {
		logger.info("Receive Message");
		return newestMessage.get();
	}
}
