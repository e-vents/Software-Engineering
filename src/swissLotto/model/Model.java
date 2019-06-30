package swissLotto.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	//List with all tips inside
	private final ObservableList<Tip> numbers = FXCollections.observableArrayList();
	static final int MAX_TIPS = 450;
	private Tip draw = null;
	private Wallet wallet;
	
	public Model() {
		this.wallet = new Wallet();
	}
	//deleting and adding Tips
	public void addTip() {
		if(numbers.size() < MAX_TIPS)
			numbers.add(new Tip(numbers.size()));
		wallet.addTip();
	}
	public void deleteTip() {
		if(!numbers.isEmpty())
			numbers.remove(numbers.size()-1);
		wallet.deleteTip();
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
		//gathering money from wins made
		for(WinnerType wt : winnerTypes) {
			if(wt != null)
				wallet.addWin(wt.getWinSum());
		}
		return winnerTypes;
	}
	
	//evaluate if lucky number equals draw lucky number
	private boolean isCorrectLuckyNumber(int i) {
		int luckyDrawNum = this.draw.getLuckyInt();
		int luckyTipNum;
		
			luckyTipNum = numbers.get(i).getLuckyInt();
		return luckyTipNum == luckyDrawNum;
	}

	public ObservableList<Tip> getTips() {
		return numbers;
	}
	public Tip getDraw() {		
		return draw;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	
	/*TODO using stream to get LottoNums as List
	private ArrayList<Integer> tipAsList(int i) {
		return (ArrayList<Integer>) numbers.stream().map(e -> e.getInt(i))
						.collect(Collectors.toList());
	}
	*/
}
