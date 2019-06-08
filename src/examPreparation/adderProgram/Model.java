package examPreparation.adderProgram;

import javafx.beans.property.SimpleIntegerProperty;

public class Model {
	
	private SimpleIntegerProperty value;
	
	public Model() {
		
		value = new SimpleIntegerProperty();
	}
	
	public void addToValue(int amount) {
		setValue(getValue() + amount);
	}
	
	public SimpleIntegerProperty getValueProperty() {
		return value;
	}
	
	public int getValue() {
		return value.get();
	}
	
	public void setValue(int newValue) {
		value.set(newValue);
	}

}
