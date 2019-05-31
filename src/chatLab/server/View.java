package chatLab.server;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends BorderPane {
	
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
		
		// Prevent labels and button from shrinking below their preferred size
		port.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
		startBtn.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
				
		// Set sizes for top TextFields
		portField.setMinWidth(60); portField.setPrefWidth(60);
		
		HBox controls = new HBox(this.port, this.portField, spacer, this.startBtn);
		controls.getStyleClass().add("hbox");
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		this.setTop(controls);
		this.setCenter(console);
		this.getStyleClass().add("root");
		
		Scene scene = new Scene(this);
		scene.getStylesheets().add(
	               getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("SimpleChatServer");
		stage.show();
	}
	
	public void start() {
		stage.show();
		
		// Prevent resizing below initial size
		stage.setMinWidth(stage.getWidth());
		stage.setMinHeight(stage.getHeight());
	}
	
	public void stop() {
		stage.hide();
		Platform.exit();
	}
	
	public Stage getStage() {
		return stage;
	}

	public void updateClients() {
		StringBuffer sb = new StringBuffer();
		for(Client c : serverModel.clients) {
			sb.append(c.toString());
			sb.append("\n");
		}
		console.setText(sb.toString());
	}
}

