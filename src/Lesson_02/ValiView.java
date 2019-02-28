package Lesson_02;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ValiView extends GridPane {
	
	@SuppressWarnings("unused")
	final private ValiModel model;
	final private Stage stage;
	
	protected Button btn;
	protected TextField ip, port;
	private Label ipLabel;
	private Label portLabel;
	
	public ValiView(ValiModel model, Stage stage) {
		this.model = model;
		this.stage = stage;
		
		this.btn = new Button("connect");
		this.btn.setDisable(true);
		this.ip = new TextField();
		this.port = new TextField();
		
		this.ipLabel = new Label("  ip address: ");
		this.portLabel = new Label("  port number: ");
		
		this.add(ipLabel, 0, 0);
		this.add(ip, 1, 0);
		
		this.add(portLabel, 2, 0);
		this.add(port, 3, 0);
		
		this.add(btn, 4, 0);
		
		Scene scene = new Scene(this);
		stage.setScene(scene);
		stage.setTitle("Validator");
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
