package swissLotto.view;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import swissLotto.model.Model;

public class InfoPane extends HBox {
	
	private final Model model;
	private final TipPane tipPane;
	private Label wallet;
	private Label jackpotText;
	private Label walletText;
	private Label spendingText;
	private Label winText;

	InfoPane(Model model, TipPane tipPane) {
		
		this.model = model;
		this.tipPane = tipPane;

		Label jackpot = new Label("Jackpot:");
		this.wallet = new Label("\tBilanz:");
		Label spending = new Label("Kosten pro Spiel:");
		Label win = new Label("Gewinnsumme:");
		
		this.jackpotText = new Label(model.getWallet().getJackpot()+"\t\t");
		this.walletText = new Label(model.getWallet().getCostsString());
		this.spendingText = new Label(model.getWallet().getSpendingMoney());
		this.winText = new Label(model.getWallet().getWin());

		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		jackpot.getStyleClass().add("infoLabel");
		this.wallet.getStyleClass().add("infoLabel");
		spending.getStyleClass().add("infoLabel");
		win.getStyleClass().add("infoLabel");
		this.jackpotText.getStyleClass().add("infoText");
		this.walletText.getStyleClass().add("infoText");
		this.spendingText.getStyleClass().add("infoText");
		this.winText.getStyleClass().add("infoText");
		
		this.getChildren().addAll(wallet, walletText,
				spending, spendingText, spacer,
				win, winText,
				jackpot, jackpotText);
		this.setAlignment(Pos.BASELINE_CENTER);
		//make infoPane clickable to show statistics
		this.setOnMouseReleased(e -> StatPopUp.showPopUp());
	}
	
	//updating info data, depending on the action-event
	public void updateInfoArea(Event e) {
		
		if(e.getSource() == tipPane.playBtn) {
			model.getWallet().fetchMoney();
			jackpotText.setText(model.getWallet().getJackpot()+"\t\t");
			wallet.setText((model.getWallet().getCosts() < 0) ? "\tVerlust:": "\tGewinn:");
			walletText.setText(model.getWallet().getCostsString());
			winText.setText(model.getWallet().getLongTermWin());
		}
		
		if(e.getSource() == tipPane.addBtn) {
			model.addTip();
			spendingText.setText(model.getWallet().getSpendingMoney());
		} 
		
		if(e.getSource() == tipPane.deleteBtn) {
			model.deleteTip();
			spendingText.setText(model.getWallet().getSpendingMoney());
		}
	}
}