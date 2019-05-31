package chatLab.client;

public class Controller {
	final private ClientModel clientModel;
	final private View view;
	
	public Controller(ClientModel clientModel, View view) {
		this.clientModel = clientModel;
		this.view = view;
		
		view.connectBtn.setOnAction(event -> {
			Integer port = new Integer(view.portField.getText());
			String ipAddress = view.ipField.getText();
			String name = view.nameField.getText();
			clientModel.connect(ipAddress, port, name);
		});
		
		view.getStage().setOnCloseRequest(event -> clientModel.disconnect());
		
		view.send.setOnAction(event -> clientModel.sendMessage(view.prompter.getText()));
		
		clientModel.newestMessage.addListener( (o, oldValue, newValue) -> view.console.appendText(newValue) );
	}	
}

