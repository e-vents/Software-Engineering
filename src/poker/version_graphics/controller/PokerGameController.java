package poker.version_graphics.controller;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
	private PokerGame game;
	private Stage stage;
	
	public PokerGameController(Stage stage, PokerGameModel model, PokerGameView view, PokerGame game) {
		this.stage = stage;
		this.model = model;
		this.view = view;
		this.game = game;
		
		view.getShuffleButton().setOnAction( e -> shuffle() );
		view.getDealButton().setOnAction( e -> deal() );
		
		//Event-Handler for the "themes" Menu
		view.getGreenItem().setOnAction(this::changeColor);
		view.getRedItem().setOnAction(this::changeColor);
		view.getGreyItem().setOnAction(this::changeColor);
		
		//Events-Handler for the "players" Menu
		view.getTwoPlayer().setOnAction(this::changeNumOfPlayers);
		view.getThreePlayer().setOnAction(this::changeNumOfPlayers);
		view.getFourPlayer().setOnAction(this::changeNumOfPlayers);
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
        		
        		if(i == PokerGame.NUM_PLAYERS-1)
        			evaluateWinner();
        	}
        	
    	} else {
            Alert alert = new Alert(AlertType.INFORMATION, "please shuffle first");
            alert.setTitle("not enought cards");
            alert.showAndWait();
    	}
    }
    //calls the displayWinner-method so that you can see who wins
    //refactoring needed!! save winner and then check with current winner!
    private void evaluateWinner() {
    	for(int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
    		if(i < PokerGame.NUM_PLAYERS-1)
    			view.getPlayerPane(i).displayWinner(model.getPlayer(i+1));
    		else
    			view.getPlayerPane(i).displayWinner(model.getPlayer(i-1));
    	}
    }
    
    //Method for changing themes (red, green and grey)
    private void changeColor(Event e) {
    	String fileName ="";
    	
    	if(e.getSource() == view.getRedItem()) {
    		view.getRoot().setId("redRoot");
    		view.getControls().setId("redControlArea");
    		fileName = "greendeck.png";
    		
    	} else if(e.getSource() == view.getGreenItem()){
    		view.getRoot().setId("greenRoot");
    		view.getControls().setId("greenControlArea");
    		fileName = "reddeck.png";
    		
    	} else {
    		view.getRoot().setId("greyRoot");
    		view.getControls().setId("greyControlArea");
    		fileName = "bluedeck.png";
    	}
    	
    	Image image = new Image(this.getClass().getClassLoader().getResourceAsStream(
    														"poker/images/" + fileName));
		ImageView imv = new ImageView(image);
		imv.setFitHeight(185);
		imv.setFitWidth(122);
		view.getDeckLabel().setGraphic(imv);
    }
    
    //implementing multi-player
    private void changeNumOfPlayers(Event d) {
    	if(d.getSource() == view.getTwoPlayer()) {
    		game.setNumOfPlayers(2);
    	}
    	if(d.getSource() == view.getThreePlayer()) {
    		game.setNumOfPlayers(3);
    	}
    	if(d.getSource() == view.getFourPlayer()) {
    		game.setNumOfPlayers(4);
    	}
    	model.updateModel();
		view.updateView(stage, model);
		shuffle();
    }
}
