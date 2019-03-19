package poker.version_graphics.controller;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.DeckOfCards;
import poker.version_graphics.model.Player;
import poker.version_graphics.model.PokerGameModel;
import poker.version_graphics.view.PlayerPane;
import poker.version_graphics.view.PokerGameView;

public class PokerGameController {
	private PokerGameModel model;
	private PokerGameView view;
	
	public PokerGameController(PokerGameModel model, PokerGameView view) {
		this.model = model;
		this.view = view;
		
		view.getShuffleButton().setOnAction( e -> shuffle() );
		view.getDealButton().setOnAction( e -> deal() );
		
		
		view.getGreenItem().setOnAction(this::changeColor);
		view.getRedItem().setOnAction(this::changeColor);
	}
	


    /**
     * Remove all cards from players hands, and shuffle the deck
     */
    private void shuffle() {
    	for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
    		Player p = model.getPlayer(i);
    		p.discardHand();
    		PlayerPane pp = view.getPlayerPane(i);
    		pp.updatePlayerDisplay();
    		view.getPlayerPane(i).resetWinner();
    	}

    	model.getDeck().shuffle();
    }
    
    /**
     * Deal each player five cards, then evaluate the two hands
     */
    private void deal() {
    	int cardsRequired = PokerGame.NUM_PLAYERS * Player.HAND_SIZE;
    	DeckOfCards deck = model.getDeck();
    	if (cardsRequired <= deck.getCardsRemaining()) {
        	for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
        		Player p = model.getPlayer(i);
        		p.discardHand();
        		for (int j = 0; j < Player.HAND_SIZE; j++) {
        			Card card = deck.dealCard();
        			p.addCard(card);
        		}
        		p.evaluateHand();
        		PlayerPane pp = view.getPlayerPane(i);
        		pp.updatePlayerDisplay();
        		//view.getPlayerPane(i).displayWinner();
        		
        	}
        	/*
        	for(int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
        		boolean winner = this.model.getPlayer(1).isWinner(i);
        		if(winner)
        			this.view.getPlayerPane(i);
        	}
        	*/
        	view.getPlayerPane(0).displayWinner();
        	
    	} else {
            Alert alert = new Alert(AlertType.ERROR, "Not enough cards - shuffle first");
            alert.showAndWait();
    	}
    }
    private void changeColor(Event e) {
    	if(e.getSource() == view.getRedItem()) {
    		view.getRoot().setId("redRoot");
    		view.getControls().setId("redControlArea");
    		//view.setFileName("greendeck.jpg");
    		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/" + "greendeck.png"));
    		ImageView imv = new ImageView(image);
    		//imv.setId("deckcards");
    		imv.setFitHeight(185);
    		imv.setFitWidth(122);
    		
    		view.getDeckLabel().setGraphic(imv);
    	} else {
    		view.getRoot().setId("greenRoot");
    		view.getControls().setId("greenControlArea");
    		//view.setFileName("deckback.png");
    		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/" + "deckback.png"));
    		ImageView imv = new ImageView(image);
    		//imv.setId("deckcards");
    		imv.setFitHeight(185);
    		imv.setFitWidth(122);
    		
    		view.getDeckLabel().setGraphic(imv);
    	}
    }
}
