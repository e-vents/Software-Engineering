package examPreparation.Whacamole;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MoleButton extends Button implements Runnable, EventHandler<ActionEvent> {

	private Whacamole main;
	private ImageView empty = new ImageView(new Image("empty.gif"));
	private ImageView mole = new ImageView(new Image("mole.gif"));
	private Thread t;
	
	public MoleButton(Whacamole main) {
		super();
		this.main = main;
		this.setGraphic(empty);
		this.setDisable(true);
		this.setOnAction(this);
		
		this.t = new Thread(this);
		t.start();
	}
	
	@Override
	public void handle(ActionEvent e) {
		main.whack();	
	}

	@Override
	public void run() {
		while(true) {
			//altering GUI
			this.setDisable(Math.random() < 0.6);
			
			Platform.runLater(() -> {
				if(this.isDisable()) {
					this.setGraphic(mole);
				} else {
					this.setGraphic(empty);
				}
				try {
					Thread.sleep(500);
				} catch(InterruptedException e) {
				}
			});
		}
	}
}
