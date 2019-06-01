package chatLab.server;

import javafx.application.Application;
import javafx.stage.Stage;

public class Server extends Application {
	
	private View view;
	private Controller controller;
	private Model serverModel;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		this.serverModel = new Model();
		this.view = new View(serverModel, stage);
		this.controller = new Controller(serverModel, view);
		
		view.start();
	}
	@Override
	public void stop() {
		if (view != null)
			view.stop();
	}
}