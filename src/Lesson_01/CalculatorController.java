package Lesson_01;

import javafx.event.Event;
import javafx.scene.control.Button;

public class CalculatorController {
	
	private CalculatorView root;
	private CalculatorModel model;
	
	public CalculatorController(CalculatorView root, CalculatorModel model) {
		this.root = root;
		this.model = model;
		this.root.getBtnClear().setOnAction(this::clear);
		this.root.getBtnEquals().setOnAction(this::equals);
		this.root.getBtnPlus().setOnAction(this::plus);
		for(Button d : this.root.getDigits()) {
			d.setOnAction(this::digits);
		}
	}
	public void clear(Event e) {
		this.root.setDisplay("");
	}
	public void plus(Event e) {
		this.root.appendDisplay("+");
	}
	public void equals(Event e) {
		String in = this.root.getDisplay();
		String out = this.model.summing(in);
		this.root.setDisplay(out);
	}
	public void digits(Event e) {
		Button b = (Button) e.getSource();
		this.root.appendDisplay(b.getText());
	}
}
