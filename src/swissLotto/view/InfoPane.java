package swissLotto.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import swissLotto.model.Model;

public class InfoPane extends HBox {
	
	private final Model model;
	private final Label jackpot;
	private final Label wallet;
	private final Label spending;
	private Label jackpotText;
	private Label walletText;
	private Label spendingText;

	public InfoPane(Model model) {
		this.model = model;
		this.jackpot = new Label("Jackpot: ");
		this.jackpot.getStyleClass().add("jackpot");
		this.wallet = new Label("Guthaben: ");
		this.wallet.getStyleClass().add("wallet");
		this.spending = new Label("eingesetztes Geld: ");
		this.spending.getStyleClass().add("spending");
		
		this.jackpotText = new Label(model.getWallet().getJackpot());
		this.jackpotText.getStyleClass().add("jackpot");
		this.walletText = new Label(model.getWallet().getMoneyToSpend());
		this.walletText.getStyleClass().add("wallet");
		this.spendingText = new Label(model.getWallet().getSpendingMoney());
		this.spendingText.getStyleClass().add("spending");
		
		this.getChildren().addAll(wallet, walletText, spending, spendingText, 
				jackpot, jackpotText);
		this.setAlignment(Pos.BOTTOM_RIGHT);
		this.setId("infoPane");
	}
	
	public void updateSpendingLabel() {
		jackpotText.setText(model.getWallet().getJackpot());
		spendingText.setText(model.getWallet().getSpendingMoney());
		walletText.setText(model.getWallet().getMoneyToSpend());
	}
	
	public void updateInfoArea() {
		model.getWallet().fetchMoney();
		jackpotText.setText(model.getWallet().getJackpot());
		spendingText.setText(model.getWallet().getSpendingMoney());
		walletText.setText(model.getWallet().getMoneyToSpend());
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