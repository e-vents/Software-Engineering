package Lesson_01;

import javafx.application.Application;
import javafx.stage.Stage;

public class Calculator extends Application {
	
	private CalculatorController controller;
	private CalculatorView root;
	private CalculatorModel model;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		this.root = new CalculatorView(stage, controller);
		this.model = new CalculatorModel();
		this.controller = new CalculatorController(root, model);
	}
}
