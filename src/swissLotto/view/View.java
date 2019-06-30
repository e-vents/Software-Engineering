package swissLotto.view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import swissLotto.model.Model;


public class View {
	
	final private Stage stage;

	private InfoPane infoPane;
	private TipPane tipPane;
	private DrawPane drawPane;
	
	public View(Stage stage, Model model) {
		//this.model = model;
		this.stage = stage;
		BorderPane borderPane = new BorderPane();
		borderPane.setId("borderPane");
		
		this.tipPane = new TipPane(model);
		this.drawPane = new DrawPane(model, tipPane);
		this.infoPane = new InfoPane(model, tipPane);
		this.drawPane.setId("drawPane");
		this.tipPane.setId("tipPane");
		this.infoPane.setId("infoPane");
		
		borderPane.setBottom(infoPane);
		borderPane.setLeft(tipPane);
		borderPane.setCenter(drawPane);
		
		Scene scene = new Scene(borderPane, 1260, 578);
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