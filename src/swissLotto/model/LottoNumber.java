package swissLotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

public class LottoNumber {
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
	
	public LottoNumber(int size) {
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
	
	private void updateRepresentations(int size) {
		tip.set(Integer.toString(size+1)+".");
		number.set(Integer.toString(this.lottoNumbers.remove(0)));
		number2.set(Integer.toString(this.lottoNumbers.remove(0)));
		number3.set(Integer.toString(this.lottoNumbers.remove(0)));
		number4.set(Integer.toString(this.lottoNumbers.remove(0)));
		number5.set(Integer.toString(this.lottoNumbers.remove(0)));
		number6.set(Integer.toString(this.lottoNumbers.remove(0)));
		luckyNumber.set(Integer.toString(this.luckyNumbers.remove(0)));
		//Logger.getLogger("").info("Representations updated: " + number.get());
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
}

