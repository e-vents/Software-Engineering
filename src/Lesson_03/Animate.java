package Lesson_03;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animate extends Application {
	
	private Rectangle eck;
	
	public void start(Stage stage) throws Exception {
	
		Group group = new Group();
		this.eck = new Rectangle(50, 50, Color.GREEN);
		group.getChildren().add(eck);
	
		PathElement p1 = new MoveTo(0, 400);
		PathElement p2 = new MoveTo(400, 400);
		PathElement p3 = new MoveTo(400, 0);
		PathElement p4 = new MoveTo(0, 0);
		PathElement p5 = new MoveTo(0, 400);
	
		Path path = new Path();
		path.getElements().add(p1);
		path.getElements().add(p2);
		path.getElements().add(p3);
		path.getElements().add(p4);
		path.getElements().add(p5);
	
		PathTransition move = new PathTransition(Duration.millis(4000), path, eck);
		move.setCycleCount((Animation.INDEFINITE));
		move.play();
		
		/*
		FillTransition fill = new FillTransition(Duration.millis(500));
		fill.setToValue(Color.RED);
		//ParallelTransition squash = new ParallelTransition(fill);
		
		SequentialTransition sequence = new SequentialTransition(path, fill);
		sequence.play();
		*/
		
		Scene scene = new Scene(group, 400, 400);
		stage.setScene(scene);
		stage.setTitle("program2");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

