package swissLotto.view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import swissLotto.Controller;

public class NumbersPane extends GridPane {

	public NumbersPane() {
		
		int counter = 1;
		//adding Buttons to choose numbers
		for (int row = 1; row < 8; row++) {
			for (int col = 1; col < 7; col++) {
				// name button with number
				Button btn = new Button(Integer.toString(counter));
				this.add(btn, col, row);
				// Set button size
				btn.setPrefSize(40, 40);
				// Event-Handler
				//btn.setOnAction(controller::numberClicked);
				counter++;
			}
		}
	}
	
}
