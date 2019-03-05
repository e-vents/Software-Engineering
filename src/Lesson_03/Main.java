package Lesson_03;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private View view;
	private Controller controller;
	private Model model;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		this.model = new Model();
		this.view = new View(model, stage);
		this.controller = new Controller(model, view);
		
		view.start();
	}
	@Override
	public void stop() {
		if (view != null)
			view.stop();
	}
}