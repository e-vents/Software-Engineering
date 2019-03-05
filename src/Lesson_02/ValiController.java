package Lesson_02;

import javafx.beans.Observable;

public class ValiController {
	
	final private ValiModel model;
	final private ValiView view;
	private boolean validIp = false;
	private boolean validPort = false;
	
	public ValiController(ValiModel model, ValiView view) {
		this.model = model;
		this.view = view;
		
		
		// ChangeListener for the text-property of the web address
		view.ip.textProperty().addListener(this::validateIp);

		// ChangeListener for the text-property of the port numbers
		view.port.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validatePort(newValue);
				});
	}
	public void validateIp(Observable obs, String oldValue, String newValue) {
	
		boolean valid = this.model.isValidIp(newValue);
		
		if(valid)
			view.ip.setStyle("-fx-text-inner-color: green;");
		else
			view.ip.setStyle("-fx-text-inner-color: red");
		
		this.validIp = valid;
		
		enableButton();
	}
	public void validatePort(String newValue) {
		
		boolean valid = this.model.isValidPort(newValue);
		
		if(valid)
			view.port.setStyle("-fx-text-inner-color: green;");
		else
			view.port.setStyle("-fx-text-inner-color: red");
		
		this.validPort = valid;
		
		enableButton();
		
	}
	public void enableButton() {
		if(this.validIp && this.validPort)
			view.btn.setDisable(false);
	}
}
