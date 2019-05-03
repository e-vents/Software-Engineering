package swissLotto.model;

import java.util.ArrayList;

import poker.version_graphics.model.Card;
import poker.version_graphics.model.HandType;

public enum WinnerType {
	Three(10, "drei richtige"), ThreePlusOne(25, "drei +1 richrige"),
	Four(75, "vier richtige"), FourPlusOne(150, "vier +1 richtige"),
	Five(1000, "fünf richtige"), FivePlusOne(10000, "fünf +1 richtige"),
	Six(1000000, "sechs richtige"), SixPlusOne(10000000, "sches +1 richtige");
	
	private int winSum;
	private String name;
	
	private WinnerType(int winSum, String name) {
		this.winSum = winSum;
		this.name = name;
	}
	
	public int getWinSum() {
		return this.winSum;
	}
	
    public static WinnerType evaluateDraw(ArrayList<Integer> tip, ArrayList<Integer> draw, boolean luckyNum) {
    	WinnerType currentEval = null;
        
        tip.retainAll(draw);
        if (tip.size() == 3) currentEval = Three;
        if (tip.size() == 3 && luckyNum) currentEval = ThreePlusOne;
        if (tip.size() == 4) currentEval = Four;
        if (tip.size() == 4 && luckyNum) currentEval = FourPlusOne;
        if (tip.size() == 5) currentEval = Five;
        if (tip.size() == 5 && luckyNum) currentEval = FivePlusOne;
        if (tip.size() == 6) currentEval = Six;
        if (tip.size() == 6 && luckyNum) currentEval = SixPlusOne;
        
        return currentEval;
    }
    @Override
    public String toString() {
    	return this.name+"! +"+this.winSum+" CHF";
    }
}
