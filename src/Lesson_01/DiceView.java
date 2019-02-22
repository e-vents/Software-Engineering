package Lesson_01;

import java.util.Random;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class DiceView extends HBox{

	private Button b1, b2;
	private String s1, s2;
	private Random rand;
	
	public DiceView() {
		
		rand = new Random();
		this.b1 = new Button();
		this.b2 = new Button();
		
		this.b1.setText("...");
		this.b2.setText("...");
		
		this.getChildren().addAll(b1, b2);
		
		this.b1.setOnAction(this::dice);
		this.b2.setOnAction(this::dice);
	}
	
	public void dice(Event e) {
		if(e.getSource() == this.b1) {
			this.s1 = String.valueOf(rand.nextInt(6)+1);
			this.b1.setText(s1);
		} else {
			this.s2 = String.valueOf(rand.nextInt(6)+1);
			this.b2.setText(s2);
		}
	}
}
