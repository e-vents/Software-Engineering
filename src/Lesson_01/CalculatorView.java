package Lesson_01;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class CalculatorView extends BorderPane {

	private Button[] digits = new Button[10];	
	private Button btnPlus, btnClear, btnEquals;
	private TextField display;
	
	public CalculatorView(Stage stage, CalculatorController controller) {
		
		for(int i = 0; i < digits.length; i++)
			digits[i] = new Button(Integer.toString(i));
		
		this.btnClear = new Button("c");
		this.btnClear.setId("btnClear");
		this.btnEquals = new Button("=");
		this.btnEquals.setId("btnEquals");
		this.btnPlus = new Button("+");
		this.btnPlus.setId("btnPlus");
		this.display = new TextField();
		
		GridPane buttons = new GridPane();
		
		for(int i = 1; i < digits.length; i++) {
			buttons.add(digits[i], (i-1) % 3,2 - (i-1) / 3);
		}
		
		buttons.add(btnClear, 3, 1);
		buttons.add(btnEquals, 3, 2, 1, 2);
		buttons.add(btnPlus, 3, 0);
		buttons.add(digits[0], 0, 3, 3, 1);
		
		this.setCenter(buttons);
		this.setTop(display);
		
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(25);
		buttons.getColumnConstraints().addAll(cc, cc, cc, cc);
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(25);
		buttons.getRowConstraints().addAll(rc, rc, rc, rc);
		
		
		Scene scene = new Scene(this, 250, 350);
		scene.getStylesheets().add(getClass().getResource("Calculator.css").toExternalForm());
		stage.setScene(scene);
		stage.setMinHeight(300);
		stage.setMinWidth(200);
		stage.setTitle("Calculator");
		stage.setOpacity(0.9);
		stage.show();
		
	}
	public CalculatorView getCalculatorView() {
		return this;
	}
	public void setDisplay(String txt) {
		this.display.setText(txt);
	}
	public String getDisplay() {
		return this.display.getText();
	}
	public void appendDisplay(String app) {
		this.display.appendText(app);
	}
	public Button[] getDigits() {
		return digits;
	}
	public Button getBtnPlus() {
		return btnPlus;
	}
	public Button getBtnClear() {
		return btnClear;
	}
	public Button getBtnEquals() {
		return btnEquals;
	}
}
