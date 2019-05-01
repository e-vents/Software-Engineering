package swissLotto.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class DrawPane extends GridPane {
	
	private Button evaluate;
	
	public DrawPane() {
		
		this.evaluate = new Button("play");
		/*
		Sphere sphere = new Sphere();
		//Setting the properties of the Sphere
		sphere.setRadius(50.0);
		sphere.setTranslateX(200);
		sphere.setTranslateY(150);
		
		this.add(sphere, 0, 0);
		*/
		this.add(evaluate, 0, 1);
		//this.setAlignment(Pos.BASELINE_CENTER);
	}
}
