package chatLab.server;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends VBox {
	
	final private ServerModel serverModel;
	final private Stage stage;
	
	private Label port;
	protected TextField portField;
	protected Button startBtn;
	protected TextArea console;
	
	public View(ServerModel serverModel, Stage stage) {
		this.serverModel = serverModel;
		this.stage = stage;
		
		this.port = new Label("Port   ");
		this.portField = new TextField();
		this.startBtn = new Button("Start");
		this.console = new TextArea();
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		HBox controls = new HBox();
		controls.getChildren().addAll(this.port, this.portField, spacer, this.startBtn);
		controls.getStyleClass().add("serverModel");
		
		HBox.setHgrow(console, Priority.ALWAYS);
		VBox.setVgrow(console, Priority.ALWAYS);
		this.getChildren().addAll(controls, this.console);
		this.getStyleClass().add("serverModel");
		
		Scene scene = new Scene(this);
		scene.getStylesheets().add(
	               getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("SimpleChatServer");
		stage.setMinHeight(150);
		stage.setMinWidth(300);
		stage.show();
	}
	
	public void start() {
		stage.show();
	}
	
	public void stop() {
		stage.hide();
		Platform.exit();
	}
	
	public Stage getStage() {
		return stage;
	}

	public Object updateClients() {
		// TODO Auto-generated method stub
		return null;
	}
}

