package lesson_01;

public class CalculatorModel {
	
	private String result;
	private int sum;

	protected String summing(String in) {
		
		String[] summands = in.split("\\+");
		
		sum = 0;
		for(String s : summands) {
			 this.sum += Integer.parseInt(s);
		}
		result = String.valueOf(sum);
		
		return result;
	}
}
