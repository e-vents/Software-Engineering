package poker.version_graphics.model;

import java.util.ArrayList;
import poker.version_graphics.PokerGame;

public class PokerGameModel {
	private final ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	
	public PokerGameModel() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			players.add(new Player("Player " + (i+1), this));
		}
		deck = new DeckOfCards();
	}
	
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	public DeckOfCards getDeck() {
		return deck;
	}
	/*
	 * call in controller for changing player number
	 */
	public void updateModel() {
		players.clear();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			players.add(new Player("Player " + (i+1), this));
		}
	}
}
