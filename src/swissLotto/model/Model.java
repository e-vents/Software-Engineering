package swissLotto.model;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import poker.version_graphics.model.HandType;

public class Model {
	//List with all tips inside
	private final ObservableList<Tip> numbers = FXCollections.observableArrayList();
	private static final int MAX_TIPS = 45;
	private Tip draw = null; 
	
	public void addTip() {
		if(numbers.size() < MAX_TIPS)
			numbers.add(new Tip(numbers.size()));
	}

	public void deleteTip() {
		if(!numbers.isEmpty())
			numbers.remove(numbers.size()-1);
	}
	
	public int getNumberOfTips() {
		return numbers.size();
	}
	
	// getters and setters
	public ObservableList<Tip> getTips() {
		return numbers;
	}
	
	public Tip getDraw() {		
		return draw;
	}
	
	//return list with the WinnerType of all Tips including null
	public ArrayList<WinnerType> evaluateDraw() {
		this.draw = new Tip();
		//System.out.println(draw.toString());

		ArrayList<Integer> draw = this.draw.LottoNumsAsList();
		ArrayList<WinnerType> winnerTypes = new ArrayList<>();
		ArrayList<Integer> tempTip;
		
		//temporary list without lucky Number
		for(int i = 0; i < numbers.size(); i++) {
			
			tempTip = numbers.get(i).LottoNumsAsList();
			
			// for each tip check for WinnerType
			winnerTypes.add(WinnerType.evaluateDraw(tempTip, draw, isCorrectLuckyNumber(i)));
		}
		return winnerTypes;
	}
	
	public boolean isCorrectLuckyNumber(int i) {
		int luckyDrawNum = this.draw.getLuckyInt();
		int luckyTipNum;
		
			luckyTipNum = numbers.get(i).getLuckyInt();
			if(luckyTipNum == luckyDrawNum) {
				return true;
		}
		return false;
	}
}
