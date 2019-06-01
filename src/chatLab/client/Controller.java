package chatLab.client;

public class Controller {
	final private Model model;
	final private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		view.connectBtn.setOnAction(event -> {
			view.connectBtn.setDisable(true);
			Integer port = new Integer(view.portField.getText());
			String ipAddress = view.ipField.getText();
			String name = view.nameField.getText();
			model.connect(ipAddress, port, name);
		});
		
		view.getStage().setOnCloseRequest(event -> model.disconnect());
		
		view.send.setOnAction(event -> model.sendMessage(view.prompter.getText()));
		
		model.newestMessage.addListener( (o, oldValue, newValue) -> {
			if(!newValue.isEmpty())
				view.console.appendText(newValue+"\n");
		} );
		
	}	
}

