package examPreparation.numberProgram;

public class Controller {
	final private Model model;
	final private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		view.root.txt.textProperty().addListener((o, oVal, nVal) -> {
			try {
				Double.parseDouble(nVal);
				view.root.bin.setDisable(false);
				view.root.hex.setDisable(false);
			} catch(Exception e) {
				view.root.bin.setDisable(true);
				view.root.hex.setDisable(true);
			}
		});
		
		view.root.hex.setOnAction(e -> {
			String s = model.toHex(view.root.txt.getText());
			view.root.lbl.setText(s);

		});
		
		view.root.bin.setOnAction(e -> {
			String s = model.toBinary(view.root.txt.getText());
			view.root.lbl.setText(s);
		});
	}	
}

