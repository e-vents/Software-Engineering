package swissLotto.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
		this.wallet = new Label("Guthaben: ");
		this.spending = new Label("eingesetztes Geld: ");
		
		this.jackpotText = new Label("10'000'000");
		this.walletText = new Label("2000.0");
		this.spendingText = new Label("0.00");
		
		this.getChildren().addAll(this.jackpot, this.jackpotText, 
				this.wallet, this.walletText, 
				this.spending, this.spendingText);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(55);
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
