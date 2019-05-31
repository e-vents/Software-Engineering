package chatLab.server;

import java.util.logging.Logger;

import chatLab.client.ClientModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServerModel {
	
	protected ObservableList<ClientModel> clients = 
			FXCollections.observableArrayList();
	
	private Logger logger = Logger.getLogger("");
	
	public void startServer(int port) {
		logger.info("Star server");
	}
	
	public void stopServer() {
		logger.info("Stop server");
	}
	
	public ObservableList<ClientModel> getClientList(){
		logger.info("Get client list");
		return clients;
	}
}
