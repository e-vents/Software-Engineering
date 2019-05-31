package chatLab.client;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {
	
	private View view;
	private Controller controller;
	private ClientModel clientModel;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		this.clientModel = new ClientModel();
		this.view = new View(clientModel, stage);
		this.controller = new Controller(clientModel, view);
		
		view.start();
	}
	@Override
	public void stop() {
		if (view != null)
			view.stop();
	}
}