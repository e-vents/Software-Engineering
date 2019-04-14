package swissLotto;

import javafx.application.Application;
import javafx.stage.Stage;
import swissLotto.model.Drawing;
import swissLotto.view.View;

public class LottoGame extends Application {
	public static int MAX_BALLS = 7;
	Drawing drawing;
	View view;
	Controller controller;
	  
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	// Create and initialize the MVC components
    	drawing = new Drawing();
    	view = new View(primaryStage, drawing);
    	controller = new Controller(drawing, view);
    	
    }
}
