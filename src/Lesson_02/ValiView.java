package Lesson_02;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ValiView extends GridPane {
	
	final private ValiModel model;
	final private Stage stage;
	
	protected Button btn;
	protected TextField ip, port;
	
	public ValiView(ValiModel model, Stage stage) {
		this.model = model;
		this.stage = stage;
		
		this.btn = new Button("submit");
		this.ip = new TextField();
		this.port = new TextField();
		
		this.add(btn, 2, 0);
		this.add(ip, 0, 0);
		this.add(port, 1, 0);
		
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
