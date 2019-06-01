package chatLab.server;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class Controller {
	final private Model model;
	final private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		view.startBtn.setOnAction(event -> {
			view.startBtn.setDisable(true);
			Integer port = new Integer(view.portField.getText());
			model.startServer(port);
		});
		
		view.getStage().setOnCloseRequest(event -> model.stopServer());
		
		model.clients.addListener((ListChangeListener) (event -> view.updateClients()));
	}
}

