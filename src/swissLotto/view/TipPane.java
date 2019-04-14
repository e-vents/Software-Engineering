package swissLotto.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import swissLotto.Controller;

public class TipPane extends VBox {
	
	protected Button plus;
	protected Button minus;
	protected VBox tipBoxes;
	protected static int tipBoxCount = 1;

	public TipPane() {
		
		this.tipBoxes = new VBox();
		//adaptive label-adding
		for(int i = 0; i < tipBoxCount; i++) {
			this.tipBoxes.getChildren().add(generateTipBox());
		}
		
		//+ & - Buttons in a HBox
		this.minus = new Button("-");
		this.plus = new Button("+");
		HBox controls = new HBox();
		controls.getChildren().add(minus);
		controls.getChildren().add(plus);
		controls.setAlignment(Pos.BOTTOM_CENTER);

		this.getChildren().add(tipBoxes);
		this.getChildren().add(controls);
	}
	
	//updates the tipPane with more or less tips
	public void updateTipPane() {
		
		this.getChildren().clear();
		//adaptive tip-adding
		for(int i = 0; i <tipBoxCount; i++) {
			this.getChildren().add(generateTipBox());
		}
		HBox controls = new HBox();
		controls.getChildren().add(minus);
		controls.getChildren().add(plus);
		controls.setAlignment(Pos.BOTTOM_CENTER);

		this.getChildren().add(controls);
	}
	
	//return a new TipBox
	private HBox generateTipBox() {
		HBox tempBox = new HBox();
		
		for(int i = 0; i <7; i++) {
			tempBox.getChildren().add(new Label("--"));
		}
		
		tempBox.setSpacing(20);
		return tempBox;
	}
	
	public Button getPlus() {
		return this.plus;
	}

	public Button getMinus() {
		return this.minus;
	}
	
	public static void setTipBoxCount(int tipBoxCount) {
		TipPane.tipBoxCount = tipBoxCount;
	}
	
	public static int getTipPaneCount() {
		return TipPane.tipBoxCount;
	}

	public VBox getTipBoxes() {
		return tipBoxes;
	}
	
}
