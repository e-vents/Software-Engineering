package swissLotto.model;

import java.text.DecimalFormat;

public class Wallet {
	
	public DecimalFormat fmt;
	private double costs;
	private double jackpot;
	private double spendingMoney;
	private double win;
	private double longTermWin;
	private static final double TIP_COST = 2.5;

	public Wallet() {
		fmt = new DecimalFormat("##,###,##0.00 CHF");
		costs = 0;
		jackpot = 10000000.0;
		spendingMoney = 0;
		win = 0;
		longTermWin = 0;
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
		costs += spendingMoney;
		costs -= win;
		win = 0;
	}

	//	---> getters and setters <---
	public String getCosts() {
		return fmt.format(costs);
	}
	public String getJackpot() {
		return fmt.format(jackpot);
	}
	public String getSpendingMoney() {
		return fmt.format(spendingMoney);
	}
	public String getLongTermWin() {
		return fmt.format(longTermWin);
	}

	public String getWin() {
		return fmt.format(win);
	}
	public void addWin(double win) {
		this.win += win;
		this.longTermWin += win;
	}
}