package examPreparation.numberProgram;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class NumbersLayoutPane extends BorderPane {

	protected NumbersButton hex = new NumbersButton("To Hex");
	protected NumbersButton bin = new NumbersButton("To Binary");
	protected NumbersResultLabel lbl = new NumbersResultLabel("Result");
	protected TextField txt = new TextField();
	
	protected NumbersLayoutPane() {
		VBox btns = new VBox(10.0, hex, bin);
		btns.setAlignment(Pos.CENTER);
		this.setCenter(btns);
		this.setLeft(txt);
		this.setRight(lbl);
		this.setStyle("-fx-padding: 10.0");
		this.setAlignment(getLeft(), Pos.CENTER);
		this.setAlignment(getRight(), Pos.CENTER);
		bin.setDisable(true);
		hex.setDisable(true);
	}
	
	public class NumbersButton extends Button {
		protected NumbersButton(String text) {
			super(text);
			this.setMaxWidth(Button.USE_PREF_SIZE);
			this.setStyle("-fx-background-color: firebrick");
			this.setStyle("-fx-text-fill: white");
			this.setStyle("-fx-background-radius: 10px");
		}
	}
	
	public class NumbersResultLabel extends Label {
		protected NumbersResultLabel(String text) {
			super(text);
			this.setMinWidth(150);
			this.setStyle("-fx-background-color: lightblue");
		}
	}
}
