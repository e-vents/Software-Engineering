package swissLotto.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import swissLotto.model.Model;

public class InfoPane extends HBox {
	
	private final Label jackpot;
	private final Label wallet;
	private final Label spending;
	private Label jackpotText;
	private Label walletText;
	private Label spendingText;

	public InfoPane(Model model) {
		
		this.jackpot = new Label("Jackpot: ");
		this.jackpot.getStyleClass().add("jackpot");
		this.wallet = new Label("Guthaben: ");
		this.wallet.getStyleClass().add("wallet");
		this.spending = new Label("eingesetztes Geld: ");
		this.spending.getStyleClass().add("spending");
		
		this.jackpotText = new Label("10'000'000");
		this.jackpotText.getStyleClass().add("jackpot");
		this.walletText = new Label("2000.0");
		this.walletText.getStyleClass().add("wallet");
		this.spendingText = new Label("0.00");
		this.spendingText.getStyleClass().add("spending");
		
		
		this.getChildren().addAll(this.wallet, this.walletText, 
				this.spending, this.spendingText, 
				this.jackpot, this.jackpotText);
		this.setAlignment(Pos.BOTTOM_RIGHT);
		//this.setSpacing(10);
		this.setId("infoPane");
	}

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

	public void addTipSpend() {
		double money = Double.parseDouble(this.spendingText.getText());
		if(money < 112.5)
		this.spendingText.setText(String.valueOf(money+2.50));
	}
	
	public void deleteTipSpend() {
		double money = Double.parseDouble(this.spendingText.getText());
		if(money > 0)
			this.spendingText.setText(String.valueOf(money-2.50));
	}
}
