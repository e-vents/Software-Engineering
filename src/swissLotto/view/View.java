package swissLotto.view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import swissLotto.Controller;
import swissLotto.model.Drawing;


public class View {
	
	final private Drawing drawing;
	final private Stage stage;
	private BorderPane borderPane;
	
	private ChoicePane choicePane;
	private TipPane tipPane;
	private DrawPane drawPane;
	
	public View(Stage stage, Drawing drawing) {
		this.drawing = drawing;
		this.stage = stage;
		this.borderPane = new BorderPane();
		
		this.choicePane = new ChoicePane();
		this.drawPane = new DrawPane();
		this.tipPane = new TipPane();
		
		this.borderPane.setLeft(this.choicePane);
		this.borderPane.setCenter(this.tipPane);
		this.borderPane.setRight(this.drawPane);
		
		Scene scene = new Scene(this.borderPane, 1000, 500);
		stage.setScene(scene);
		stage.setTitle("Swiss Lotto");
		stage.show();
	}
	public void start() {
		stage.show();
	}
	public void stop() {
		stage.hide();
		Platform.exit();
	}
	
	//getters and setters from TipPane
	public ChoicePane getChoicePane() {
		return choicePane;
	}
	public TipPane getTipPane() {
		return tipPane;
	}
	public DrawPane getDrawPane() {
		return drawPane;
	}
	/*
	public Button getPlus() {
		return this.tipPane.plus;
	}

	public Button getMinus() {
		return this.tipPane.minus;
	}

	
	public static void setTipBoxCount(int tipBoxCount) {
		TipPane.tipBoxCount = tipBoxCount;
	}
	public static int getTipPaneCount() {
		return TipPane.tipBoxCount;
	}
	*/
}