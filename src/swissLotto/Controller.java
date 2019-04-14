package swissLotto;

import java.lang.reflect.Array;

import javafx.event.Event;
import javafx.scene.control.Label;
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
		
		Tip tp = new Tip();
		Label lbl = null;
		int[] labels = new int[7];
		
		for(int i = 0; i < 7; i++) {
			
			lbl = (Label) view.getTipPane().getTipBoxes().getChildren().toArray(labels);
			
			for(Integer tip : tp) {
				lbl.setText(Integer.toString(tip));
			}
		}
	}
	
	public void tipAdding() {
		if(view.getTipPane().getTipPaneCount() > 1)
				view.getTipPane().setTipBoxCount(view.getTipPane().getTipPaneCount()-1);
		
		view.getTipPane().updateTipPane();
		
	}
	
	public void tipDeleting() {
		if(view.getTipPane().getTipPaneCount()< 10)
			view.getTipPane().setTipBoxCount(view.getTipPane().getTipPaneCount()+1);
		
		view.getTipPane().updateTipPane();
	}
}
