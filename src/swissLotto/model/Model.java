package swissLotto.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	//List with all tips inside
	private final ObservableList<Tip> numbers = FXCollections.observableArrayList();
	private static final int MAX_TIPS = 14;
	private final Tip draw; 
	
	public Model() {
		draw = new Tip();
	}
	
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
	
	
}
