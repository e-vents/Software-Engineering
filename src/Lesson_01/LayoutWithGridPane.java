package Lesson_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class LayoutWithGridPane extends Application {
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
		
		GridPane root = new GridPane();
		
		Label spacer1 = new Label();
		Label spacer2 = new Label();
		
		root.add(alpha, 0, 0);
		root.add(beta, 0, 1);
		root.add(spacer1, 0, 2);
		root.add(delta, 0, 3);
		root.add(gamma, 0, 4);
		root.add(left, 1, 6);
		root.add(spacer2, 2, 6);
		root.add(right, 3, 6);
		root.add(bigText, 1, 0, 3, 6);
		
		for(int i = 0; i < 3; i++) {
			ColumnConstraints cc = new ColumnConstraints();
			if(i == 2)
				cc.setHgrow(Priority.ALWAYS);
			root.getColumnConstraints().add(cc);
		}
		for(int i = 0; i < 6; i++) {
			RowConstraints rc = new RowConstraints();
			if (i == 5)
				rc.setVgrow(Priority.ALWAYS);
			root.getRowConstraints().add(rc);
		}
		
		Scene scene = new Scene(root);
	    primaryStage.setTitle("Layout exercise");
	    primaryStage.setScene(scene);
	    primaryStage.setMinHeight(200);
	    primaryStage.setMinWidth(300);
	    primaryStage.show();
	}
}
