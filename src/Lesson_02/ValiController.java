package Lesson_02;

public class ValiController {
	
	final private ValiModel model;
	final private ValiView view;
	
	public ValiController(ValiModel model, ValiView view) {
		this.model = model;
		this.view = view;
		
		view.ip.textProperty().addListener(
				(observable, oldValue, newValue) -> validateIp(newValue));
		
		view.port.textProperty().addListener(
				(observable, oldValue, newValue) -> validatePort(newValue));
	}
	public void validateIp(String s) {
		
		
	}
	public void validatePort(String s) {
		
		
	}
	
}
