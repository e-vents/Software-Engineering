package swissLotto.model;

import java.util.ArrayList;

public enum WinnerType {
	Three(10, "3 Richtige"), ThreePlusOne(25, "3+1 Richtige"),
	Four(75, "4 Richtige"), FourPlusOne(150, "4+1 Richtige"),
	Five(1000, "5 Richtige"), FivePlusOne(10000, "5+1 Richtige"),
	Six(1000000, "6 Richtige"), SixPlusOne(10000000, "6+1 Richtige");
	
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
    	return this.name+"! "+this.winSum+".- Gewinn";
    }
}
