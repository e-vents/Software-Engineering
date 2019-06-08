package examPreparation.adderProgram;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View {
	
	final private Model model;
	final private Stage stage;
	
	protected Label lblTotal = new Label();
	protected Button btnAdd = new Button("Add amount to total");
	protected TextField txtAmount = new TextField("0");
	
	private ScaleTransition pulse;
	
	public View(Model model, Stage stage) {
		this.model = model;
		this.stage = stage;
		
		this.lblTotal.textProperty().bind(model.getValueProperty().asString());
		
		Pane root = createLayout();
		pulse = createAnimation();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("program");
		stage.show();
	}
	
	private Pane createLayout() {
		
		VBox root = new VBox(10.0, txtAmount, btnAdd, new Region(), lblTotal);
		btnAdd.setMaxWidth(10000); //Button grows with resizing
		VBox.setVgrow(root.getChildren().get(2), Priority.ALWAYS);
		root.setStyle("-fx-padding: 10.0px;");
		
		return root;
	}
	
	private ScaleTransition createAnimation() {
		ScaleTransition pulse = new ScaleTransition(Duration.millis(1000));
		pulse.setToX(1.5);
		pulse.setToY(1.5);
		pulse.setAutoReverse(true);
		//two cycles important!
		pulse.setCycleCount(2);
		pulse.setNode(lblTotal); //dont forget to set node
		return pulse;
	}
	
	public void start() {
		stage.show();
	}
	
	public void stop() {
		stage.hide();
		Platform.exit();
	}
	
	protected Stage getStage() {
		return stage;
	}
	
	protected void doAnimate() {
		pulse.play();
	}
}

