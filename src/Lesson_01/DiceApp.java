package Lesson_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DiceApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception{
		DiceView root = new DiceView();
		root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
