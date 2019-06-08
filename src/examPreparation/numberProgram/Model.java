package examPreparation.numberProgram;

public class Model {
	
	protected Model() {
	}
	
	protected String toHex(String decimal) {
		Integer value = Integer.parseInt(decimal);
		return Integer.toHexString(value);
	}
	
	protected String toBinary(String decimal) {
		Integer value = Integer.parseInt(decimal);
		return Integer.toBinaryString(value);
	}
}
