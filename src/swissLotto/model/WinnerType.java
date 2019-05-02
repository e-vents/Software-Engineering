package swissLotto.model;

import java.util.ArrayList;

import poker.version_graphics.model.Card;
import poker.version_graphics.model.HandType;

public enum WinnerType {
	ThreeRight, ThreePlusOneRight,
	FourRight, FourPlusOneRight,
	FiveRight, FivePlusOneRight,
	SixRight, SixPlusOneRight;
	
	
    public static WinnerType evaluateDraw(ArrayList<Integer> tip, ArrayList<Integer> draw, boolean luckyNum) {
    	WinnerType currentEval = null;
        
        tip.retainAll(draw);
        if (tip.size() == 3) currentEval = ThreeRight;
        if (tip.size() == 3 && luckyNum) currentEval = ThreePlusOneRight;
        if (tip.size() == 4) currentEval = FourRight;
        if (tip.size() == 4 && luckyNum) currentEval = FourPlusOneRight;
        if (tip.size() == 5) currentEval = FiveRight;
        if (tip.size() == 5 && luckyNum) currentEval = FivePlusOneRight;
        if (tip.size() == 6) currentEval = SixRight;
        if (tip.size() == 6 && luckyNum) currentEval = SixPlusOneRight;
        
        return currentEval;
    }
}
