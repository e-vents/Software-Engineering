package lesson_01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutWithHBoxVBox extends Application {
	
	private Button b1 = new Button("alpha");
	private Button b2 = new Button("beta");
	private Button b3 = new Button("gamma");
	private Button b4 = new Button("delta");
	private Button b5 = new Button("left");
	private Button b6 = new Button("right");
	private TextArea t1 = new TextArea(
			"Lorem ipsum dolor sit amet,\n" +
			"consetetur sadipscing elitr,\n" +
			"sed diam nonumy eirmod tempor,\n" +
			"invidunt ut labore et dolore,\n" +
			"magna aliquyam erat, sed diam,\n" +
			"voluptua. At vero eos et accusam,\n" +
			"et justo duo dolores et ea rebum.,\n" +
			"Stet clita kasd gubergren, no sea,\n" +
			"takimata sanctus est Lorem ipsum,\n" +
			"dolor sit amet. Lorem ipsum dolor,\n" +
			"sit amet, consetetur sadipscing,\n" +
			"elitr, sed diam nonumy eirmod,\n" +
			"tempor invidunt ut labore et,\n" +
			"dolore magna aliquyam erat, sed,\n" +
			"diam voluptua. At vero eos et,\n" +
			"accusam et justo duo dolores et,\n" +
			"ea rebum. Stet clita kasd,\n" +
			"gubergren, no sea takimata sanctus,\n" +
			"est Lorem ipsum dolor sit amet.");

	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) throws Exception {
		
		VBox btns = new VBox();
		Region spacer1 = new Region();
		spacer1.setPrefHeight(30);
		btns.getChildren().addAll(b1,b2,spacer1,b3,b4);
		
		b1.setMinWidth(Region.USE_PREF_SIZE);
	    b2.setMinWidth(Region.USE_PREF_SIZE);
	    b3.setMinWidth(Region.USE_PREF_SIZE);
	    b4.setMinWidth(Region.USE_PREF_SIZE);
		
		HBox navi = new HBox();
		Region spacer2 = new Region();
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		navi.getChildren().addAll(b5,spacer2, b6);
		
		VBox.setVgrow(t1, Priority.ALWAYS);
		VBox txt = new VBox();
		txt.getChildren().addAll(t1, navi);
		
		HBox all = new HBox();
		all.getChildren().addAll(btns, txt);
		
		Scene scene = new Scene(all, 500,300);
		stage.setScene(scene);
		stage.show();
	}

}
