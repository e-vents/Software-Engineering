package chatLab.server;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class Controller {
	final private ServerModel serverModel;
	final private View view;
	
	public Controller(ServerModel serverModel, View view) {
		this.serverModel = serverModel;
		this.view = view;
		
		view.startBtn.setOnAction(event -> {
				Integer port = new Integer(view.portField.getText());
				serverModel.startServer(port);
		});
		
		view.getStage().setOnCloseRequest(event -> serverModel.stopServer());
		
		serverModel.clients.addListener((ListChangeListener) (event -> view.updateClients()));
	}
}

