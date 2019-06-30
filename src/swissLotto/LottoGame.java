package swissLotto;

import javafx.application.Application;
import javafx.stage.Stage;
import swissLotto.model.Model;
import swissLotto.view.View;

public class LottoGame extends Application {
	private Model model;
	private View view;
	private Controller controller;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
    	// Create and initialize the MVC components
    	model = new Model();
    	view = new View(primaryStage, model);
    	controller = new Controller(model, view);
    }
}