package Lesson_02;

import javafx.application.Application;
import javafx.stage.Stage;

public class Vali extends Application {
	
	private ValiView view;
	private ValiController controller;
	private ValiModel model;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		this.model = new ValiModel();
		this.view = new ValiView(model, stage);
		this.controller = new ValiController(model, view);
		
		view.start();
	}
	@Override
	public void stop() {
		if (view != null)
			view.stop();
	}
}
