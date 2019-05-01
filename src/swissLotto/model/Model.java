package swissLotto.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

	private final ObservableList<LottoNumber> numbers = FXCollections.observableArrayList();
	
	public void addNewNumber() {
		if(numbers.size() < 14)
			numbers.add(new LottoNumber(numbers.size()));
	}

	public void deleteNumber() {
		if(!numbers.isEmpty())
			numbers.remove(numbers.size()-1);
	}
	
	public int getNumberSize() {
		return numbers.size();
	}
	
	// getters and setters
	public ObservableList<LottoNumber> getElements() {
		return numbers;
	}
	
}
