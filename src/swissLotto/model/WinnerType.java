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
	//getter
	public int getWinSum() {
		return this.winSum;
	}
	//evaluate a single tip with the draw
    public static WinnerType evaluateDraw(ArrayList<Integer> tip, ArrayList<Integer> draw, boolean luckyNum) {
    	WinnerType winType = null;
        
        tip.retainAll(draw);
        if (tip.size() == 3) winType = Three;
        if (tip.size() == 3 && luckyNum) winType = ThreePlusOne;
        if (tip.size() == 4) winType = Four;
        if (tip.size() == 4 && luckyNum) winType = FourPlusOne;
        if (tip.size() == 5) winType = Five;
        if (tip.size() == 5 && luckyNum) winType = FivePlusOne;
        if (tip.size() == 6) winType = Six;
        if (tip.size() == 6 && luckyNum) winType = SixPlusOne;
        return winType;
    }
    @Override
    public String toString() {
    	return this.name+"! "+this.winSum+".- Gewinn";
    }
}