package poker.version_graphics.model;

import java.util.ArrayList;

import poker.version_graphics.PokerGame;
import poker.version_graphics.view.PlayerPane;

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
	
	public void updateModel() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			players.add(new Player("Player " + (i+1), this));
		}
		deck = new DeckOfCards();
	}
}
