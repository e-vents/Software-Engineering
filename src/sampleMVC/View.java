package sampleMVC;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View extends GridPane {
	
	final private Model model;
	final private Stage stage;
	
	
	public View(Model model, Stage stage) {
		this.model = model;
		this.stage = stage;
		
		
		
		Scene scene = new Scene(this);
		stage.setScene(scene);
		stage.setTitle("program");
		stage.show();
	}
	public void start() {
		stage.show();
	}
	
	public void stop() {
		stage.hide();
		Platform.exit();
	}
}

