package swissLotto.model;

import java.util.ArrayList;
import java.util.Collections;
import javafx.beans.property.SimpleStringProperty;

public class Tip {
	
	private ArrayList<Integer> lottoIntegers;
	private ArrayList<Integer> luckyNumbers;
	private final SimpleStringProperty tip = new SimpleStringProperty();
	private final SimpleStringProperty[] lottoNums;
	private final SimpleStringProperty luckyNumber = new SimpleStringProperty();
	
	//constructor for tips and lottery draw
	public Tip(int size) {
		//instancciate regular Lotto numbers
		this.lottoNums = new SimpleStringProperty[6];
		for(int i = 0; i < lottoNums.length; i++) {
			lottoNums[i] = new SimpleStringProperty();
		}
		//get a list with all posible lottoNumbers
		this.lottoIntegers = new ArrayList<>();
		for (int i=1; i<43; i++) {
            lottoIntegers.add(i);
        }
		Collections.shuffle(lottoIntegers);
		//get a list with all posible luckyNumbers
		this.luckyNumbers = new ArrayList<>();
		for (int i=1; i<7; i++) {
            luckyNumbers.add(i);
        }
		Collections.shuffle(luckyNumbers);
		updateRepresentations(size);
	}
	
	//updates the properties with the recent numbers
	private void updateRepresentations(int size) {
		tip.set(Integer.toString(size+1)+"."); //display tipNumber
		for(int i = 0; i < lottoNums.length; i++) {
			lottoNums[i].set(Integer.toString(getLottoNum(i)));
		}
		luckyNumber.set(Integer.toString(this.luckyNumbers.remove(0)));
	}
	//make shure the Lotto number are sorted
	private int getLottoNum(int index) {
		ArrayList<Integer> tempNums = new ArrayList<Integer>();
		for(int i = 0; i < 6; i++) {
			tempNums.add(this.lottoIntegers.get(i));
		}
		Collections.sort(tempNums);
		return tempNums.get(index);
	}
	//makes a Integer-list out of the Properties 
	public ArrayList<Integer> LottoNumsAsList() {
		//TODO make as stream!
		ArrayList<Integer> intList = new ArrayList<>();
		for(int i = 0; i < 6; i++) {
			intList.add(getInt(i));
		}		
		return intList; 
	}
	
	//getters and setters
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
		String toString = "";
		//lottoNums to string
		for(int i = 0; i < 6; i++) {
			toString = toString+ getInt(i)+", ";
		}
		//luckyNum to string
		toString = toString+"& luckyNum: "+getLuckyInt();
		return toString;
	}
}