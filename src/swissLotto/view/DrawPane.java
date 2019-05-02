package swissLotto.view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import swissLotto.model.Model;
import swissLotto.model.WinnerType;

public class DrawPane extends GridPane {
	
	private Model model;
	private Button evaluate;
	private ArrayList<WinnerType> winnerTypes;
	
	public DrawPane(Model model) {
		this.model = model;
		
		this.evaluate = new Button("play");
		/*
		Sphere sphere = new Sphere();
		//Setting the properties of the Sphere
		sphere.setRadius(50.0);
		sphere.setTranslateX(200);
		sphere.setTranslateY(150);
		
		this.add(sphere, 0, 0);
		*/
		this.add(evaluate, 0, 1);
		//this.setAlignment(Pos.BASELINE_CENTER);
		
	}
	
	public void displayWinner() {
		this.winnerTypes = model.evaluateDraw();
		
		for(int i = 0; i < winnerTypes.size(); i++) {
			
			if(winnerTypes.get(i) != null) {
				
				if(winnerTypes.get(i).equals(WinnerType.ThreeRight))
					System.out.println("you have three correct ones with your "+(i+1)+". tip");
				if(winnerTypes.get(i).equals(WinnerType.ThreePlusOneRight))
					System.out.println("you have three +1 correct ones with your "+(i+1)+". tip");
				
				if(winnerTypes.get(i).equals(WinnerType.FourRight))
					System.out.println("you have four correct ones with your "+(i+1)+". tip");
				if(winnerTypes.get(i).equals(WinnerType.FourPlusOneRight))
					System.out.println("you have four +1 correct ones with your "+(i+1)+". tip");
				
				if(winnerTypes.get(i).equals(WinnerType.FiveRight))
					System.out.println("you have five correct ones! with your "+(i+1)+". tip");
				if(winnerTypes.get(i).equals(WinnerType.FivePlusOneRight))
					System.out.println("you have five +1 correct ones with your "+(i+1)+". tip");
				
				if(winnerTypes.get(i).equals(WinnerType.SixRight))
					System.out.println("you have six correct ones! with your "+(i+1)+". tip");
				if(winnerTypes.get(i).equals(WinnerType.SixPlusOneRight))
					System.out.println("you have six +1 correct ones with your "+(i+1)+". tip");
				
			} else
				System.out.println("you lost with your "+(i+1)+". tip");
		}
	}

	public Button getEvaluate() {
		return evaluate;
	}
	
}
