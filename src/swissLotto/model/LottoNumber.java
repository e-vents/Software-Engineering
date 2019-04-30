package swissLotto.model;

import java.util.Random;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

public class LottoNumber {
	
	private static Random rand = new Random();
	private static final int MAX_VALUE = 42;
	
	//private Integer value = 0;
	private final SimpleStringProperty number = new SimpleStringProperty();
	private final SimpleStringProperty number2 = new SimpleStringProperty();
	private final SimpleStringProperty number3 = new SimpleStringProperty();
	private final SimpleStringProperty number4 = new SimpleStringProperty();
	private final SimpleStringProperty number5 = new SimpleStringProperty();
	private final SimpleStringProperty number6 = new SimpleStringProperty();
	private final SimpleStringProperty number7 = new SimpleStringProperty();
	/*
	public LottoNumber(int value) {
		if(value > 0 && value < 43)
			this.value = value;
		updateRepresentations();
	}
	*/
	public LottoNumber() {
		
		updateRepresentations();
	}
	
	private void updateRepresentations() {
		number.set(Integer.toString(generateRandNum()));
		number2.set(Integer.toString(generateRandNum()));
		number3.set(Integer.toString(generateRandNum()));
		number4.set(Integer.toString(generateRandNum()));
		number5.set(Integer.toString(generateRandNum()));
		number6.set(Integer.toString(generateRandNum()));
		number7.set(Integer.toString(generateRandNum()));
		//Logger.getLogger("").info("Representations updated: " + number.get());
	}
	private int generateRandNum() {
		return rand.nextInt(MAX_VALUE)+1;
	}
	
	//--- Getters and Setters ---
	
	// Note: The naming is CRITICAL, because the TableView will derive method
	// names from the property names that it is given.

	public SimpleStringProperty getNumberProperty() {
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

	public SimpleStringProperty getNumber7() {
		return number7;
	}

	public String getNumberAsString() {
		return number.get();
	}
	/*
	public void setAsDecimal(String newValue) {
		value = Integer.parseInt(newValue);
		updateRepresentations();
	}

	public SimpleStringProperty asBinaryProperty() {
		return asBinary;
	}
	
	public String getAsBinary() {
		return asBinary.get();
	}
	*/
	public void setNumber(String newValue) {
		//value = Integer.parseInt(newValue);
		updateRepresentations();
	}
	/*
	public SimpleStringProperty asHexadecimalProperty() {
		return asHexadecimal;
	}
	
	public String getAsHexadecimal() {
		return asHexadecimal.get();
	}

	public void setAsHexadecimal(String newValue) {
		value = Integer.parseInt(newValue, 16);
		updateRepresentations();
	}
	*/
}

