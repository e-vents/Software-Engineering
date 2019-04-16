package swissLotto.model;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Drawing {
	
	private static Random rand = new Random();
	
	private final ObservableList<SuperNumber> elements = FXCollections.observableArrayList();

	public void addNewElement() {
		elements.add(new SuperNumber(generateRandNum()));
	}

	// getters and setters
	public ObservableList<SuperNumber> getElements() {
		return elements;
	}
	private int generateRandNum() {
		return rand.nextInt(41+1);
	}
}
