package swissLotto.model;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

public class SuperNumber {
	private Integer value = 0;
	private final SimpleStringProperty number = new SimpleStringProperty();
	
	public SuperNumber(int value) {
		if(value > 0 && value < 43)
			this.value = value;
		updateRepresentations();
	}
	
	private void updateRepresentations() {
		number.set(value.toString());
		Logger.getLogger("").info("Representations updated: " + number.get());
	}
	
	//--- Getters and Setters ---
	
	// Note: The naming is CRITICAL, because the TableView will derive method
	// names from the property names that it is given.

	public SimpleStringProperty asDecimalProperty() {
		return number;
	}
	/*
	public String getAsDecimal() {
		return asDecimal.get();
	}
	
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
		value = Integer.parseInt(newValue);
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

