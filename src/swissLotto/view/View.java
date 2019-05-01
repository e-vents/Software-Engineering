package swissLotto.view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import swissLotto.model.Model;


public class View {
	
	//final private Model model;
	final private Stage stage;
	private BorderPane borderPane;
	
	//private ChoicePane choicePane;
	private TipPane tipPane;
	private DrawPane drawPane;
	
	public View(Stage stage, Model model) {
		//this.model = model;
		this.stage = stage;
		this.borderPane = new BorderPane();
		
		//this.choicePane = new ChoicePane();
		this.drawPane = new DrawPane();
		this.tipPane = new TipPane(model);
		
		//this.borderPane.setLeft(this.choicePane);
		this.borderPane.setCenter(this.tipPane);
		this.borderPane.setRight(this.drawPane);
		
		Scene scene = new Scene(this.borderPane, 1200, 456);
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
	/*
	public ChoicePane getChoicePane() {
		return choicePane;
	}
	*/
	public TipPane getTipPane() {
		return tipPane;
	}
	public DrawPane getDrawPane() {
		return drawPane;
	}
}