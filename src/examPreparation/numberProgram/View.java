package examPreparation.numberProgram;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View {
	
	final private Model model;
	final private Stage stage;
	
	NumbersLayoutPane root;
	
	protected View(Model model, Stage stage) {
		this.model = model;
		this.stage = stage;
		
		root = new NumbersLayoutPane();
		
		Scene scene = new Scene(root);
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

