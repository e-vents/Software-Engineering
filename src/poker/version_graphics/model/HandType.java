package poker.version_graphics.model;

import java.util.ArrayList;

public enum HandType {
    HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush;
    
    /**
     * Determine the value of this hand. Note that this does not
     * account for any tie-breaking.
     */
    public static HandType evaluateHand(ArrayList<Card> cards) {
        HandType currentEval = HighCard;
        
        if (isOnePair(cards)) currentEval = OnePair;
        if (isTwoPair(cards)) currentEval = TwoPair;
        if (isThreeOfAKind(cards)) currentEval = ThreeOfAKind;
        if (isStraight(cards)) currentEval = Straight;
        if (isFlush(cards)) currentEval = Flush;
        if (isFullHouse(cards)) currentEval = FullHouse;
        if (isFourOfAKind(cards)) currentEval = FourOfAKind;
        if (isStraightFlush(cards)) currentEval = StraightFlush;
        
        return currentEval;
    }
    
    public static boolean isOnePair(ArrayList<Card> cards) {
        boolean found = false;
        for(int i = 0; i < cards.size() - 1 && !found; i++) {
            for(int j = i+1; j < cards.size() && !found; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) found = true;
            }
        }
        return found;
    }
    
    public static boolean isTwoPair(ArrayList<Card> cards) {
        // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

        // Find the first pair; if found, remove the cards from the list
        boolean firstPairFound = false;
        for(int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
            for(int j = i+1; j < clonedCards.size() && !firstPairFound; j++) {
                if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()) {
                    firstPairFound = true;
                    clonedCards.remove(j);  // Remove the later card
                    clonedCards.remove(i);  // Before the earlier one
                }
            }
        }
        // If a first pair was found, see if there is a second pair
        return firstPairFound && isOnePair(clonedCards);
    }
    
    public static boolean isThreeOfAKind(ArrayList<Card> cards) {
        boolean found = false;
        
        for(int i = 0; i < cards.size() - 1 && !found; i++) {
            for(int j = i+1; j < cards.size() && !found; j++) {
            	for(int y = j+1; y < cards.size() && !found; y++) {
            		if (cards.get(i).getRank() == cards.get(j).getRank()
            			&& cards.get(i).getRank() == cards.get(y).getRank()) 
            			found = true;
            	}
            }
        }
        return found;
    }
    
    public static boolean isStraight(ArrayList<Card> cards) {
    	boolean found = false;
        
        for(int i = 0; i < cards.size() - 1 && !found; i++) {
            for(int j = i+1; j < cards.size() && !found; j++) {
            	for(int y = j+1; y < cards.size() && !found; y++) {
            		for(int v = j+1; v < cards.size() && !found; v++)
            		if (cards.get(i).getRank().ordinal() == cards.get(j).getRank().ordinal()+1 
            		&& cards.get(i).getRank().ordinal() == cards.get(y).getRank().ordinal()+1 
            		&& cards.get(i).getRank().ordinal() == cards.get(v).getRank().ordinal()+1) 
            			found = true;
            	}
            }
        }
    	
        return false;
    }
    
    public static boolean isFlush(ArrayList<Card> cards) {
    	boolean found = false;
        
        for(int i = 0; i < cards.size() - 1 && !found; i++) {
            for(int j = i+1; j < cards.size() && !found; j++) {
            	if (cards.get(i).getSuit() == cards.get(j).getSuit())
                	found = true;
            }
        }
    	
        return false;
    }
    
    public static boolean isFullHouse(ArrayList<Card> cards) {
    	 // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

        // Find the first pair; if found, remove the cards from the list
        boolean threeOfAKindFound = false;
        for(int i = 0; i < clonedCards.size() - 1 && !threeOfAKindFound; i++) {
            for(int j = i+1; j < clonedCards.size() && !threeOfAKindFound; j++) {
            	for(int y = j+1; y < cards.size() && !threeOfAKindFound; y++) {
            		if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()
            			&& clonedCards.get(i).getRank() == clonedCards.get(y).getRank()) {
            			threeOfAKindFound = true;
                        clonedCards.remove(y);
            			clonedCards.remove(j);  // Remove the later card
                        clonedCards.remove(i);  // Before the earlier one
            		}
                }
            }
        }
        // If a first pair was found, see if there is a second pair
        return threeOfAKindFound && isOnePair(clonedCards);
    }
    
    public static boolean isFourOfAKind(ArrayList<Card> cards) {
    	boolean found = false;
        
        for(int i = 0; i < cards.size() - 1 && !found; i++) {
            for(int j = i+1; j < cards.size() && !found; j++) {
            	for(int y = j+1; y < cards.size() && !found; y++) {
            		for(int v = y+1; v < cards.size() && !found; v++) {
            			if (cards.get(i).getRank() == cards.get(j).getRank()
            				&& cards.get(i).getRank() == cards.get(y).getRank()
            				&& cards.get(i).getRank() == cards.get(v).getRank()) 
                			found = true;
            		}
            		
            	}
            }
        }
        return found;
    }
    
    public static boolean isStraightFlush(ArrayList<Card> cards) {
        // TODO        
        return false;
    }
}
