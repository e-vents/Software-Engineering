package examPreparation.adderProgram;

public class Controller {
	final private Model model;
	final private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		
		model.getValueProperty().addListener((obsevable, oldValue, newValue) -> {
			if(newValue.intValue() < 0)
				view.doAnimate();
		});
		
		view.btnAdd.setOnAction(event -> {
			int amount = Integer.parseInt(view.txtAmount.getText());
			model.addToValue(amount);
		});
	}	
}

