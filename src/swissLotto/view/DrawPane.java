package swissLotto.view;

import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.util.Duration;
import swissLotto.model.Model;
import swissLotto.model.WinnerType;

public class DrawPane extends VBox {
	
	private Model model;
	private ArrayList<WinnerType> winnerTypes;
	private HBox lottoBalls;
	private Label status;
	private Label[] lottoNums;

	public DrawPane(Model model) {
		this.model = model;
		status = new Label("");
		status.setId("status");
		
		lottoBalls = new HBox();
		//instanciate all Draw-Labels
		lottoNums = new Label[7];
		for(int i = 0; i < lottoNums.length; i++) {
			lottoNums[i] = new Label();
			lottoBalls.getChildren().add(lottoNums[i]);
			if(i != 6)
				lottoNums[i].getStyleClass().add("lottoBalls");
			else
				lottoNums[i].getStyleClass().add("luckyBall");
		}
		lottoBalls.setSpacing(15);
		lottoBalls.setAlignment(Pos.CENTER);
		lottoBalls.setVisible(false);
		
		this.getChildren().addAll(lottoBalls, status);
		this.setSpacing(50);
		this.setAlignment(Pos.CENTER);
	}
	
	//displays wins or losses
	public void updateDrawArea() {
		winnerTypes = model.evaluateDraw();
		lottoBalls.setVisible(true);
		displayDraw();
		animateBalls();
		status.setText("");
		for(int i = 0; i < winnerTypes.size(); i++) {
			//if there are any tips winning
			if(winnerTypes.get(i) != null) {
				//evaluate wins
				if(winnerTypes.get(i).equals(WinnerType.Three))
					status.setText(status.getText()+WinnerType.Three.toString()+" mit Nr. "+(i+1)+"\n");		
				if(winnerTypes.get(i).equals(WinnerType.ThreePlusOne))
					status.setText(status.getText()+WinnerType.ThreePlusOne.toString()+" mit Nr. "+(i+1)+"\n");
					
				if(winnerTypes.get(i).equals(WinnerType.Four))
					status.setText(status.getText()+WinnerType.Four.toString()+" mit Nr. "+(i+1)+"\n");
				if(winnerTypes.get(i).equals(WinnerType.FourPlusOne))
					status.setText(status.getText()+WinnerType.FourPlusOne.toString()+" mit Nr. "+(i+1)+"\n");
				
				if(winnerTypes.get(i).equals(WinnerType.Five))
					status.setText(status.getText()+WinnerType.Five.toString()+" mit Nr. "+(i+1)+"\n");
				if(winnerTypes.get(i).equals(WinnerType.FivePlusOne))
					status.setText(WinnerType.FivePlusOne.toString()+" mit Nr. "+(i+1)+"\n");
				
				if(winnerTypes.get(i).equals(WinnerType.Six))
					status.setText(status.getText()+WinnerType.Six.toString()+" mit Nr. "+(i+1)+"\n");
				if(winnerTypes.get(i).equals(WinnerType.SixPlusOne))
					status.setText(status.getText()+WinnerType.SixPlusOne.toString()+" mit Nr. "+(i+1)+"\n");
			}
		}//if no tip wins
		if(status.getText().equals(""))
			status.setText("Leider kein Gewinn");
	}
	
	//get and display the draw numbers 
	private void displayDraw() {
		ArrayList<Integer> draw = model.getDraw().LottoNumsAsList();
		int luckyNum = model.getDraw().getLuckyInt();
		
		for(int i = 0; i < draw.size()+1; i++) {
			Label l = (Label) lottoBalls.getChildren().get(i);
			if(i != 6) {
				if(draw.get(i) < 10)
					l.setText(" "+Integer.toString(draw.get(i)));
				else
					l.setText(Integer.toString(draw.get(i)));
			} else
				l.setText(" "+Integer.toString(luckyNum));
		}
	}
	
	//animating lottoBalls & luckyBall
	private void animateBalls() {
		//starting points for the Balls
		PathElement[] starts = new PathElement[7];
		for(int i = 0; i < starts.length; i++) {
			if(i != 6)
				starts[i] = new MoveTo(130-(i*65), -300);
			else
				starts[i] = new MoveTo(300, -300);
		}
		//lineTo points for all Balls
		PathElement[] lines = new PathElement[7];
		for(int i = 0; i < lines.length; i++) {
			if(i != 6)
				lines[i] = new LineTo(23+i, 25);
			else
				lines[i] = new LineTo(29, 25);
		}
		//adding all elements to the paths
		Path[] paths = new Path[7];
		for(int i = 0; i < paths.length; i++) {
			paths[i] = new Path();
			paths[i].getElements().addAll(starts[i], lines[i]);
		}
		//creating pathTransitions on Balls
		PathTransition[] transitions = new PathTransition[7];
		for(int i = 0; i < transitions.length; i++) {
			transitions[i] = new PathTransition(Duration.millis(800), paths[i], lottoNums[i]);
		}
		//creating rotations on Balls
		RotateTransition[] turns = new RotateTransition[7];
		for(int i = 0; i < turns.length; i++) {
			turns[i] = new RotateTransition(Duration.millis(300), lottoNums[i]);
			turns[i].setByAngle(360);
			turns[i].setCycleCount(3);
		}
		//delay for displaying the evaluation
		FadeTransition statusFade = new FadeTransition(Duration.millis(200), status);
		statusFade.setFromValue(0.0);
	    statusFade.setToValue(1.0);
	    statusFade.delayProperty().set(Duration.millis(700));
		//parallelize animations and play them
	    ParallelTransition[] parallels = new ParallelTransition[7];
		for(int i = 0; i < parallels.length; i++) {

			if(i != 6) {
				parallels[i] = new ParallelTransition(transitions[i], turns[i]);
				parallels[i].play();
			}	
			else {
				parallels[i] = new ParallelTransition(transitions[i], turns[i], statusFade);
				parallels[i].play();
			}
		}
	}
}