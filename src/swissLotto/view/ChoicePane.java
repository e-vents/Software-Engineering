package swissLotto.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import swissLotto.Controller;

public class ChoicePane extends VBox {
	
	//private NumbersPane numbersPane;
	private Button randomBtn;
	private HBox luckyBallBox;

	public ChoicePane() {
		
		//this.getChildren().add(this.numbersPane = new NumbersPane());
		this.getChildren().add(new Label("Glückszahlen"));
		
		this.luckyBallBox = new HBox();
		
		int counter = 1;
		for(int i = 0; i < 6; i++) {
			Button btn = new Button(Integer.toString(counter));
			this.luckyBallBox.getChildren().add(btn);
			btn.setPrefSize(40, 40);
			counter++;
		}
		this.getChildren().add(luckyBallBox);
		this.getChildren().add(this.randomBtn = new Button("Zufallszahlen"));
		
	}
	public Button getRandomBtn() {
		return randomBtn;
	}
	
}
