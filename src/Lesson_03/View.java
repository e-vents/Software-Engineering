package Lesson_03;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View extends Group {
	
	final private Model model;
	final private Stage stage;
	private Rectangle eck;
	
	public View(Model model, Stage stage) {
		this.model = model;
		this.stage = stage;
		
		this.eck = new Rectangle(50, 50);
		this.getChildren().add(eck);
		
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
		
		Scene scene = new Scene(this, 400, 400);
		stage.setScene(scene);
		stage.setTitle("program");
		stage.show();
	}
	public void start() {
		stage.show();
	}
	
	public void stop() {
		stage.hide();
		Platform.exit();
	}
}

