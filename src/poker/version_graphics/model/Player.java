package poker.version_graphics.model;

import java.util.ArrayList;
import java.util.Collections;

public class Player implements Comparable<Player> {
    public static final int HAND_SIZE = 5;
    
    private final String playerName; // This is the ID
    private final ArrayList<Card> cards = new ArrayList<>();
    private HandType handType;
    private PokerGameModel model;
    
    public Player(String playerName, PokerGameModel model) {
        this.playerName = playerName;
        this.model = model;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public Card getHighestCard() {
    	ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
    	Collections.sort(clonedCards);
   	 	return clonedCards.get(clonedCards.size()-1);
    }
    public Card getSecondHighestCard() {
    	 ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
    	 Collections.sort(clonedCards);
    	 return clonedCards.get(clonedCards.size()-2);
    }
    public Card getThirdHighestCard() {
   	 ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
   	 Collections.sort(clonedCards);
   	 return clonedCards.get(clonedCards.size()-3);
    }
    public Card getFourthHighestCard() {
    	ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
    	Collections.sort(clonedCards);
    	return clonedCards.get(clonedCards.size()-4); 
    }
    public Card getLowestCard() {
    	ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
    	Collections.sort(clonedCards);
    	return clonedCards.get(clonedCards.size()-5); 
    }
    
    public void addCard(Card card) {
        if (cards.size() < HAND_SIZE) cards.add(card);
    }
    
    public void discardHand() {
        cards.clear();
        handType = null;
    }
    
    public int getNumCards() {
        return cards.size();
    }

    /**
     * If the hand has not been evaluated, but does have all cards, 
     * then evaluate it.
     */
    public HandType evaluateHand() {
        if (handType == null && cards.size() == HAND_SIZE) {
            handType = HandType.evaluateHand(cards);
        }
        return handType;
    }

    /**
     * Hands are compared, based on the evaluation they have.
     */
    @Override
    public int compareTo(Player o) {
        return handType.compareTo(o.handType);
    }
}
