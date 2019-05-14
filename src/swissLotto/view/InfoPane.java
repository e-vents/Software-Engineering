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
	private final Label jackpot;
	private Label wallet;
	private final Label spending;
	private final Label win;
	private Label jackpotText;
	private Label walletText;
	private Label spendingText;
	private Label winText;

	public InfoPane(Model model, TipPane tipPane) {
		
		this.model = model;
		this.tipPane = tipPane;
		
		this.jackpot = new Label("Jackpot:");
		this.wallet = new Label("\tBilanz:");
		this.spending = new Label("Kosten pro Spiel:");
		this.win = new Label("Gewinnsumme:");
		
		this.jackpotText = new Label(model.getWallet().getJackpot()+"\t\t");
		this.walletText = new Label(model.getWallet().getCostsString());
		this.spendingText = new Label(model.getWallet().getSpendingMoney());
		this.winText = new Label(model.getWallet().getWin());

		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		this.jackpot.getStyleClass().add("infoLabel");
		this.wallet.getStyleClass().add("infoLabel");
		this.spending.getStyleClass().add("infoLabel");
		this.win.getStyleClass().add("infoLabel");
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

	//	---> getters and setters <---
	public Label getJackpotText() {
		return jackpotText;
	}
	public void setJackpotText(String text) {
		this.jackpotText.setText(text);
	}
	public Label getWalletText() {
		return walletText;
	}
	public void setWalletText(String text) {
		this.walletText.setText(text);
	}
	public Label getSpendingText() {
		return spendingText;
	}
	public void setSpendingText(String text) {
		this.spendingText.setText(text);
	}
}