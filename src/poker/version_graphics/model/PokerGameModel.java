package poker.version_graphics.model;

import java.util.ArrayList;

import poker.version_graphics.PokerGame;
import poker.version_graphics.view.PlayerPane;

public class PokerGameModel {
	private final ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	
	public PokerGameModel() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			players.add(new Player("Player " + i, this));
		}
		
		deck = new DeckOfCards();
	}
	
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	public DeckOfCards getDeck() {
		return deck;
	}
	//evaluateWinner
	public void evaluateWinner() {
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).compareTo(players.get(i+1)) > 0);
				
		}
	}
}
