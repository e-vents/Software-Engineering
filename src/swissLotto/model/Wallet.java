package swissLotto.model;

import java.text.DecimalFormat;

public class Wallet {
	
	public DecimalFormat fmt;
	private double moneyToSpend;
	private double jackpot;
	private double spendingMoney;
	private double win;
	private static final double TIP_COST = 2.5;

	public Wallet() {
		fmt = new DecimalFormat("##,###,##0.00 CHF");
		moneyToSpend = 5000.0;
		jackpot = 10000000.0;
		spendingMoney = 0;
		win = 0;
	}
	
	public void addTip() {
		if(spendingMoney < Model.MAX_TIPS*TIP_COST)
			spendingMoney += TIP_COST;
		
	}
	public void deleteTip() {
		if(spendingMoney > 0)
			spendingMoney -= TIP_COST;
	}
	public void fetchMoney() {
		jackpot += spendingMoney;
		moneyToSpend -= spendingMoney;
		moneyToSpend += win;
		win = 0;
	}

	public String getMoneyToSpend() {
		return fmt.format(moneyToSpend);
	}
	public void setMoneyToSpend(double moneyToSpend) {
		this.moneyToSpend = moneyToSpend;
	}
	
	public String getJackpot() {
		return fmt.format(jackpot);
	}
	public void setJackpot(double jackpot) {
		this.jackpot = jackpot;

	}

	public String getSpendingMoney() {
		return fmt.format(spendingMoney);
	}
	public void setSpendingMoney(double spendingMoney) {
		this.spendingMoney = spendingMoney;

	}

	public String getWin() {
		return fmt.format(win);
	}
	public void addWin(double win) {
		this.win += win;
	}
}