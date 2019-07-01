package swissLotto;

import javafx.application.Application;
import javafx.stage.Stage;
import swissLotto.model.Model;
import swissLotto.view.View;

public class LottoGame extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
    	// Create and initialize the MVC components
        Model model = new Model();
        View view = new View(primaryStage, model);
        Controller controller = new Controller(model, view);
    }
}