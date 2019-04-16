package swissLotto.model;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	
	private static Random rand = new Random();
	
	private final ObservableList<LottoNumber> numbers = FXCollections.observableArrayList();

	public void addNewNumber() {
		numbers.add(new LottoNumber());
	}

	// getters and setters
	public ObservableList<LottoNumber> getElements() {
		return numbers;
	}
	
}
