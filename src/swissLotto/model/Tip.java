package swissLotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.beans.property.SimpleStringProperty;

public class Tip {
	
	private ArrayList<Integer> lottoIntegers;
	private Random rand = new Random();
	private final SimpleStringProperty tip = new SimpleStringProperty();
	private final SimpleStringProperty[] lottoNums;
	private final SimpleStringProperty luckyNumber = new SimpleStringProperty();
	
	//constructor for tips and lottery draw
	Tip(int size) {
		//instantiate regular Lotto numbers
		this.lottoNums = new SimpleStringProperty[6];
		for(int i = 0; i < lottoNums.length; i++) {
			lottoNums[i] = new SimpleStringProperty();
		}
		//get a list with all possible lottoNumbers
		this.lottoIntegers = new ArrayList<>();
		for (int i=1; i<43; i++) {
            lottoIntegers.add(i);
        }//shuffle numbers for coincidence
		Collections.shuffle(lottoIntegers);
		updateRepresentations(size);
	}
	
	//updates the properties with the recent numbers
	private void updateRepresentations(int size) {
		tip.set((size+1)+"."); //display tipNumber
		for(int i = 0; i < lottoNums.length; i++) {
			lottoNums[i].set(Integer.toString(getLottoNum(i)));
		}
		luckyNumber.set(Integer.toString(rand.nextInt(6)+1));
	}
	
	//make shure the Lotto number are sorted
	private int getLottoNum(int index) {
		ArrayList<Integer> tempNums = new ArrayList<>();
		for(int i = 0; i < 6; i++) {
			tempNums.add(this.lottoIntegers.get(i));
		}
		Collections.sort(tempNums);
		return tempNums.get(index);
	}
	
	//makes a Integer-list out of the Properties 
	public ArrayList<Integer> LottoNumsAsList() {
		ArrayList<Integer> intList = new ArrayList<>();
		for(int i = 0; i < 6; i++) {
			intList.add(getInt(i));
		}		
		return intList; 
	}
	
	//	---> getters and setters <---
	public SimpleStringProperty getTipProperty() {
		return tip;
	}
	public SimpleStringProperty getNumberProperty(int i) {
		return lottoNums[i];
	}
	public SimpleStringProperty getLuckyNumberProperty() {
		return luckyNumber;
	}
	
	public int getInt(int i) {
		return Integer.parseInt(lottoNums[i].get());
	}
	public int getLuckyInt() {
		return Integer.parseInt(luckyNumber.get());
	}
	
	public void setNumber(int i, String newValue) {
		lottoNums[i].setValue(newValue);
	}
	public void setLuckyNumber(String newValue) {
		this.luckyNumber.setValue(newValue);
	}
	
	@Override
	public String toString() {
		StringBuilder tipString = new StringBuilder();
		//lottoNums to string
		for(int i = 0; i < 6; i++) {
			tipString.append(getInt(i));
			tipString.append(", ");
		}
		//luckyNum to string
		tipString.append("& luckyNum: ");
		tipString.append(getLuckyInt());
		return tipString.toString();
	}
}