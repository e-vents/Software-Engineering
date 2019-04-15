package swissLotto;

import java.lang.reflect.Array;

import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import swissLotto.model.Drawing;
import swissLotto.model.Tip;
import swissLotto.view.View;

public class Controller {
	final private Drawing drawing;
	final private View view;
	
	public Controller(Drawing drawing, View view) {
		this.view = view;
		this.drawing = drawing;
		
		view.getChoicePane().getRandomBtn().setOnAction(e -> randomClicked() );
		view.getTipPane().getMinus().setOnAction(e -> tipAdding() );
		view.getTipPane().getPlus().setOnAction(e -> tipDeleting() );
	}
	
	public void numberClicked(Event e) {
		
	}
	
	public void randomClicked() {
		
		Tip tip = new Tip();
		HBox hbox = new HBox();
		hbox = (HBox) view.getTipPane().getChildren().get(0);
		Label lbl = null;
		
		for(int i = 0; i < 7; i++) {
			lbl = (Label) hbox.getChildren().get(i);
			lbl.setText(Integer.toString(tip.get(i)));
		}
	}
	
	public void tipAdding() {
		if(view.getTipPane().getTipBoxCount() > 1)
				view.getTipPane().setTipBoxCount(view.getTipPane().getTipBoxCount()-1);
		
		view.getTipPane().updateTipPane();
		
	}
	
	public void tipDeleting() {
		if(view.getTipPane().getTipBoxCount()< 10)
			view.getTipPane().setTipBoxCount(view.getTipPane().getTipBoxCount()+1);
		
		view.getTipPane().updateTipPane();
	}
}
