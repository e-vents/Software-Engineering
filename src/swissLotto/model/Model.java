package swissLotto.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	
	public ObservableList<Tip> getTips() {
		return numbers;
	}
	/*TODO using stream to get LottoNums as List
	private ArrayList<Integer> tipAsList(int i) {
		return (ArrayList<Integer>) numbers.stream().map(e -> e.getInt(i))
						.collect(Collectors.toList());
	}
	*/
	public Tip getDraw() {		
		return draw;
	}
	//return list with the WinnerType of all Tips including null
	public ArrayList<WinnerType> evaluateDraw() {
		draw = new Tip(-1); //lottery draws first

		ArrayList<Integer> drawNums = draw.LottoNumsAsList();
		ArrayList<WinnerType> winnerTypes = new ArrayList<>();
		ArrayList<Integer> nextTip;
		
		//temporary list without lucky Number
		for(int i = 0; i < numbers.size(); i++) {
			
			nextTip = numbers.get(i).LottoNumsAsList();
			// for each tip --> evaluate wins
			winnerTypes.add(WinnerType.evaluateDraw(nextTip, drawNums, isCorrectLuckyNumber(i)));
		}
		return winnerTypes;
	}
	//evaluate if lucky number equals draw lucky number
	private boolean isCorrectLuckyNumber(int i) {
		int luckyDrawNum = this.draw.getLuckyInt();
		int luckyTipNum;
		
			luckyTipNum = numbers.get(i).getLuckyInt();
			if(luckyTipNum == luckyDrawNum) {
				return true;
		}
		return false;
	}
}
