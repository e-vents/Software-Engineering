package chatLab.client;

import chatLab.client.ClientModel;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends VBox {
	
	final private ClientModel clientModel;
	final private Stage stage;
	
	private Label ip;
	protected TextField ipField;
	private Label port;
	protected TextField portField;
	private Label name;
	protected TextField nameField;
	protected Button connectBtn;
	protected TextArea console;
	protected TextField prompter;
	protected Button send;
	
	public View(ClientModel clientModel, Stage stage) {
		this.clientModel = clientModel;
		this.stage = stage;
		
		this.ip = new Label("IP Address   ");
		this.port = new Label("   Port   ");
		this.name = new Label("   Name   ");
		this.ipField = new TextField();
		this.portField = new TextField();
		this.nameField = new TextField();
		this.connectBtn = new Button("Connect");
		this.console = new TextArea();
		this.prompter = new TextField();
		this.send = new Button("Send");
		HBox.setHgrow(nameField, Priority.ALWAYS);
		HBox.setHgrow(prompter, Priority.ALWAYS);
		
		HBox controls = new HBox();
		controls.getChildren().addAll(this.ip, this.ipField, 
										this.port, this.portField, 
										this.name, this.nameField, this.connectBtn);
		controls.getStyleClass().add("clientModel");
		
		HBox promtControl = new HBox();
		promtControl.getChildren().addAll(this.prompter, this.send);
		promtControl.getStyleClass().add("clientModel");
		
		HBox.setHgrow(console, Priority.ALWAYS);
		VBox.setVgrow(console, Priority.ALWAYS);
		this.getChildren().addAll(controls, this.console, promtControl);
		this.getStyleClass().add("clientModel");
		
		Scene scene = new Scene(this);
		scene.getStylesheets().add(
	              getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("SimpleChatClient");
		stage.setMinHeight(220);
		stage.setMinWidth(750);
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
}

