package swissLotto.view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import swissLotto.model.Model;


public class View {
	
	final private Stage stage;
	private BorderPane borderPane;
	
	private InfoPane infoPane;
	private TipPane tipPane;
	private DrawPane drawPane;
	
	public View(Stage stage, Model model) {
		//this.model = model;
		this.stage = stage;
		this.borderPane = new BorderPane();
		this.borderPane.setId("borderPane");
		
		this.drawPane = new DrawPane(model);
		this.tipPane = new TipPane(model);
		this.infoPane = new InfoPane(model, tipPane);
		this.drawPane.setId("drawPane");
		this.tipPane.setId("tipPane");
		this.infoPane.setId("infoPane");
		
		this.borderPane.setBottom(infoPane);
		this.borderPane.setLeft(tipPane);
		this.borderPane.setCenter(drawPane);
		
		Scene scene = new Scene(this.borderPane, 1310, 578);
		 scene.getStylesheets().add(
	                getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.setMinHeight(350);
		stage.setMinWidth(1200);
		stage.setTitle("SwissLotto");
		stage.getIcons().add(new Image("swissLotto/images/swissLotto_logo.png"));
		stage.show();
	}
	public void start() {
		stage.show();
	}
	public void stop() {
		stage.hide();
		Platform.exit();
	}
	//	---> getters <---
	public TipPane getTipPane() {
		return tipPane;
	}
	public DrawPane getDrawPane() {
		return drawPane;
	}
	public InfoPane getInfoPane() {
		return infoPane;
	}
}