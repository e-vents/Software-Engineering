package swissLotto.model;

import java.util.ArrayList;

public class Drawing {
	
	private ArrayList<Tip> tips;
	private Tip lotteryDraw;
	
	public Drawing() {
		this.lotteryDraw = new Tip();
		this.tips = new ArrayList<Tip>();
		
	}
	
	public WinnerType isWinner() {
		return WinnerType.FivePlusOneRight;
	}
}
