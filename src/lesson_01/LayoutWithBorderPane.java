package lesson_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutWithBorderPane extends Application {
	Button alpha = new Button("alpha");
	Button beta = new Button("beta");
	Button delta = new Button("delta");
	Button gamma = new Button("gamma");
	Button left = new Button("left");
	Button right = new Button("right");
	TextArea bigText = new TextArea(
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
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox btns = new VBox();
		Region spacer1 = new Region();
		spacer1.setPrefHeight(30);
		btns.getChildren().addAll(alpha,beta,spacer1,gamma, delta);
		alpha.setMinWidth(Region.USE_PREF_SIZE);
	    beta.setMinWidth(Region.USE_PREF_SIZE);
	    gamma.setMinWidth(Region.USE_PREF_SIZE);
	    delta.setMinWidth(Region.USE_PREF_SIZE);
	    
	    HBox navi = new HBox();
	    Region spacer2 = new Region();
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		navi.getChildren().addAll(left,spacer2, right);
		
		BorderPane root = new BorderPane();
		root.setLeft(btns);
		root.setCenter(bigText);
		root.setBottom(navi);
		
		Scene scene = new Scene(root);
	    primaryStage.setTitle("Layout exercise");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
}