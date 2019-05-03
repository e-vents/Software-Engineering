package swissLotto.view;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import swissLotto.model.Model;
import swissLotto.model.WinnerType;

public class DrawPane extends VBox {
	
	private Model model;
	private Button evaluate;
	private ArrayList<WinnerType> winnerTypes;
	private HBox lottoBalls;
	
	private Label status;
	private Label num1;
	private Label num2;
	private Label num3;
	private Label num4;
	private Label num5;
	private Label num6;
	private Label luckyNum;
	
	public DrawPane(Model model) {
		this.model = model;
		
		this.evaluate = new Button("play");
		this.status = new Label("");
		
		num1 = new Label();
		num1.getStyleClass().add("lottoBalls");
		num2 = new Label();
		num2.getStyleClass().add("lottoBalls");
		num3 = new Label();
		num3.getStyleClass().add("lottoBalls");
		num4 = new Label();
		num4.getStyleClass().add("lottoBalls");
		num5 = new Label();
		num5.getStyleClass().add("lottoBalls");
		num6 = new Label();
		num6.getStyleClass().add("lottoBalls");
		luckyNum = new Label();
		luckyNum.getStyleClass().add("luckyBall");
		
		lottoBalls = new HBox();
		lottoBalls.getChildren().addAll(num1, num2, num3, num4, num5, num6, luckyNum);
		lottoBalls.setSpacing(15);
		lottoBalls.setAlignment(Pos.CENTER);
		//lottoBalls.getStyleClass().add("lottoBalls");
		
		this.getChildren().addAll(lottoBalls, status, evaluate);
		this.setSpacing(50);
		this.setAlignment(Pos.CENTER);
		
		
	}
	
	public void displayWinner() {
		this.winnerTypes = model.evaluateDraw();
		displayDraw();
		animateBalls();
		this.status.setText("");
		for(int i = 0; i < winnerTypes.size(); i++) {
			
			if(winnerTypes.get(i) != null) {
				
				if(winnerTypes.get(i).equals(WinnerType.Three))
					status.setText(status.getText()+WinnerType.Three.toString()+" mit Tip "+(i+1)+"\n");
					
				if(winnerTypes.get(i).equals(WinnerType.ThreePlusOne))
					status.setText(status.getText()+WinnerType.ThreePlusOne.toString()+" mit Tip "+(i+1)+"\n");
					
				
				if(winnerTypes.get(i).equals(WinnerType.Four))
					status.setText(status.getText()+WinnerType.Four.toString()+" mit Tip "+(i+1)+"\n");
					
				if(winnerTypes.get(i).equals(WinnerType.FourPlusOne))
					status.setText(status.getText()+WinnerType.FourPlusOne.toString()+" mit Tip "+(i+1)+"\n");
					
				
				if(winnerTypes.get(i).equals(WinnerType.Five))
					status.setText(status.getText()+WinnerType.Five.toString()+" mit Tip "+(i+1)+"\n");
					
				if(winnerTypes.get(i).equals(WinnerType.FivePlusOne))
					status.setText(WinnerType.FivePlusOne.toString()+" mit Tip "+(i+1)+"\n");
					
				
				if(winnerTypes.get(i).equals(WinnerType.Six))
					status.setText(status.getText()+WinnerType.Six.toString()+" mit Tip "+(i+1)+"\n");
					
				if(winnerTypes.get(i).equals(WinnerType.SixPlusOne))
					status.setText(status.getText()+WinnerType.SixPlusOne.toString()+" mit Tip "+(i+1)+"\n");
			}
		}
		if(this.status.getText().equals(""))
			this.status.setText("leider kein Gewinn");
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

	public Button getEvaluate() {
		return evaluate;
	}
	private void animateBalls() {
		
		PathElement pe1 = new MoveTo(200, -200); // Start position
		PathElement pe11 = new LineTo(23, 25);
		//Rotate ro1 = new Rotate(3);
		PathElement pe2 = new MoveTo(300, -200); // Start position
		PathElement pe22 = new LineTo(24, 25);
		PathElement pe3 = new MoveTo(400, -200); // Start position
		PathElement pe33 = new LineTo(25, 25);
		PathElement pe4 = new MoveTo(0, -200); // Start position
		PathElement pe44 = new LineTo(26, 25);
		PathElement pe5 = new MoveTo(-400, -200); // Start position
		PathElement pe55 = new LineTo(27, 25);
		PathElement pe6 = new MoveTo(-300, -200); // Start position
		PathElement pe66 = new LineTo(28, 25);
		PathElement pe7 = new MoveTo(-200, -200); // Start position
		PathElement pe77 = new LineTo(29, 25);
		//PathElement pe3 = new ArcTo(50, 100, 0, 300, 450, false, false);
		Path path = new Path();
		path.getElements().add(pe1);
		path.getElements().add(pe11);
		Path path2 = new Path();
		path2.getElements().add(pe2);
		path2.getElements().add(pe22);
		Path path3 = new Path();
		path3.getElements().add(pe3);
		path3.getElements().add(pe33);
		Path path4 = new Path();
		path4.getElements().add(pe4);
		path4.getElements().add(pe44);
		Path path5 = new Path();
		path5.getElements().add(pe5);
		path5.getElements().add(pe55);
		Path path6 = new Path();
		path6.getElements().add(pe6);
		path6.getElements().add(pe66);
		Path path7 = new Path();
		path7.getElements().add(pe7);
		path7.getElements().add(pe77);
		//path.getElements().add(pe3);
		PathTransition move = new PathTransition(Duration.millis(2000), path, num1);
		PathTransition move2 = new PathTransition(Duration.millis(2000), path2, num2);
		PathTransition move3 = new PathTransition(Duration.millis(2000), path3, num3);
		PathTransition move4 = new PathTransition(Duration.millis(2000), path4, num4);
		PathTransition move5 = new PathTransition(Duration.millis(2000), path5, num5);
		PathTransition move6 = new PathTransition(Duration.millis(2000), path6, num6);
		PathTransition move7 = new PathTransition(Duration.millis(2000), path7, luckyNum);
		
		RotateTransition t = new RotateTransition(Duration.millis(600), num1);
		t.setByAngle(360);
		t.setCycleCount(3);
		RotateTransition t2 = new RotateTransition(Duration.millis(600), num2);
		t2.setByAngle(360);
		t2.setCycleCount(3);
		RotateTransition t3 = new RotateTransition(Duration.millis(600), num3);
		t3.setByAngle(360);
		t3.setCycleCount(3);
		RotateTransition t4 = new RotateTransition(Duration.millis(600), num4);
		t4.setByAngle(360);
		t4.setCycleCount(3);
		RotateTransition t5 = new RotateTransition(Duration.millis(600), num5);
		t5.setByAngle(360);
		t5.setCycleCount(3);
		RotateTransition t6 = new RotateTransition(Duration.millis(600), num6);
		t6.setByAngle(360);
		t6.setCycleCount(3);
		RotateTransition t7 = new RotateTransition(Duration.millis(600), luckyNum);
		t7.setByAngle(360);
		t7.setCycleCount(3);
		
		ParallelTransition para = new ParallelTransition(move, t);
		ParallelTransition para2 = new ParallelTransition(move2, t2);
		ParallelTransition para3 = new ParallelTransition(move3, t3);
		ParallelTransition para4 = new ParallelTransition(move4, t4);
		ParallelTransition para5 = new ParallelTransition(move5, t5);
		ParallelTransition para6 = new ParallelTransition(move6, t6);
		ParallelTransition para7 = new ParallelTransition(move7, t7);
		//move.setAutoReverse(true);
		//move.setCycleCount(Animation.INDEFINITE);
		//move.play();
		para.play();
		para2.play();
		para3.play();
		para4.play();
		para5.play();
		para6.play();
		para7.play();
	}
	
}
