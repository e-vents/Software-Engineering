package swissLotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

public class Tip {
	private ArrayList<Integer> lottoNumbers;
	private ArrayList<Integer> luckyNumbers;
	
	private final SimpleStringProperty tip = new SimpleStringProperty();
	private final SimpleStringProperty number = new SimpleStringProperty();
	private final SimpleStringProperty number2 = new SimpleStringProperty();
	private final SimpleStringProperty number3 = new SimpleStringProperty();
	private final SimpleStringProperty number4 = new SimpleStringProperty();
	private final SimpleStringProperty number5 = new SimpleStringProperty();
	private final SimpleStringProperty number6 = new SimpleStringProperty();
	private final SimpleStringProperty luckyNumber = new SimpleStringProperty();
	
	//constructor for draw of the lottery
	public Tip() {
		this.lottoNumbers = new ArrayList<>();
		for (int i=1; i<43; i++) {
            lottoNumbers.add(i);
        }
		Collections.shuffle(lottoNumbers);
		
		this.luckyNumbers = new ArrayList<>();
		for (int i=1; i<7; i++) {
            luckyNumbers.add(i);
        }
		Collections.shuffle(luckyNumbers);
		
		updateRepresentations();
	}
	//constructor for tips
	public Tip(int size) {
		this.lottoNumbers = new ArrayList<>();
		for (int i=1; i<43; i++) {
            lottoNumbers.add(i);
        }
		Collections.shuffle(lottoNumbers);
		
		this.luckyNumbers = new ArrayList<>();
		for (int i=1; i<7; i++) {
            luckyNumbers.add(i);
        }
		Collections.shuffle(luckyNumbers);
		
		updateRepresentations(size);
	}
	//update-method for tips
	private void updateRepresentations(int size) {
		tip.set(Integer.toString(size+1)+".");
		number.set(Integer.toString(getLottoNum(0)));
		number2.set(Integer.toString(getLottoNum(1)));
		number3.set(Integer.toString(getLottoNum(2)));
		number4.set(Integer.toString(getLottoNum(3)));
		number5.set(Integer.toString(getLottoNum(4)));
		number6.set(Integer.toString(getLottoNum(5)));
		luckyNumber.set(Integer.toString(this.luckyNumbers.remove(0)));
		//Logger.getLogger("").info("Representations updated: " + number.get());
	}
	// update-Method for the lottery draw
	private void updateRepresentations() {
		number.set(Integer.toString(getLottoNum(0)));
		number2.set(Integer.toString(getLottoNum(1)));
		number3.set(Integer.toString(getLottoNum(2)));
		number4.set(Integer.toString(getLottoNum(3)));
		number5.set(Integer.toString(getLottoNum(4)));
		number6.set(Integer.toString(getLottoNum(5)));
		luckyNumber.set(Integer.toString(this.luckyNumbers.remove(0)));
		//Logger.getLogger("").info("Representations updated: " + number.get());
	}
	//make shure the Lotto number are sorted
	private int getLottoNum(int index) {
		ArrayList<Integer> tempNums = new ArrayList<Integer>();
		for(int i = 0; i < 6; i++) {
			tempNums.add(this.lottoNumbers.get(i));
		}
		Collections.sort(tempNums);
		return tempNums.get(index);
	}
	//--- Getters and Setters ---
	
	// Note: The naming is CRITICAL, because the TableView will derive method
	// names from the property names that it is given.
	
	public SimpleStringProperty getTipProperty() {
		return tip;
	}
	
	public SimpleStringProperty getNumber() {
		return number;
	}
	
	public SimpleStringProperty getNumber2() {
		return number2;
	}

	public SimpleStringProperty getNumber3() {
		return number3;
	}

	public SimpleStringProperty getNumber4() {
		return number4;
	}

	public SimpleStringProperty getNumber5() {
		return number5;
	}

	public SimpleStringProperty getNumber6() {
		return number6;
	}

	public SimpleStringProperty getLuckyNumber() {
		return luckyNumber;
	}
	
	public int getInt() {
		return Integer.parseInt(number.get());
	}
	
	public int getInt2() {
		return Integer.parseInt(number2.get());
	}
	
	public int getInt3() {
		return Integer.parseInt(number3.get());
	}
	
	public int getInt4() {
		return Integer.parseInt(number4.get());
	}
	
	public int getInt5() {
		return Integer.parseInt(number5.get());
	}
	
	public int getInt6() {
		return Integer.parseInt(number6.get());
	}
	
	public int getLuckyInt() {
		return Integer.parseInt(luckyNumber.get());
	}
	
	public ArrayList<Integer> LottoNumsAsList() {
		
		ArrayList<Integer> lottoNumsList = new ArrayList<>();
		lottoNumsList.add(getInt());
		lottoNumsList.add(getInt2());
		lottoNumsList.add(getInt3());
		lottoNumsList.add(getInt4());
		lottoNumsList.add(getInt5());
		lottoNumsList.add(getInt6());
		
		return lottoNumsList; 
	}
	
	public void setTip(String newValue) {
		this.tip.setValue(newValue);
	}
	
	public void setNumber(String newValue) {
		this.number.setValue(newValue);
	}
	
	public void setNumber2(String newValue) {
		this.number2.setValue(newValue);
	}
	
	public void setNumber3(String newValue) {
		this.number3.setValue(newValue);
	}
	
	public void setNumber4(String newValue) {
		this.number4.setValue(newValue);
	}
	
	public void setNumber5(String newValue) {
		this.number5.setValue(newValue);
	}
	
	public void setNumber6(String newValue) {
		this.number6.setValue(newValue);
	}
	
	public void setLuckyNumber(String newValue) {
		this.luckyNumber.setValue(newValue);
	}
	
	@Override
	public String toString() {
		return getInt()+", "+
				getInt2()+", "+
				getInt3()+", "+
				getInt4()+", "+
				getInt5()+", "+
				getInt6()+"& luckyNum: "+
				getLuckyInt();
	}
}

