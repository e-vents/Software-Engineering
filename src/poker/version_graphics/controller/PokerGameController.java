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
	private Boolean autoShuffle;
	
	public PokerGameController(Stage stage, PokerGameModel model, PokerGameView view, PokerGame game) {
		this.stage = stage;
		this.model = model;
		this.view = view;
		this.game = game;
		this.autoShuffle = false;
		
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
		
		//Events-Handler for the "autoShuffle" Menu
		view.getAutoShuffleDisable().setOnAction(this::autoShuffle);
		view.getAutoShuffleEnable().setOnAction(this::autoShuffle);
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
        		PlayerPane pp = view.getPlayerPane(i);
        		pp.updatePlayerDisplay();
        		
        		// after the last player got his cards, we look for the winner
        		if(i == PokerGame.NUM_PLAYERS-1)
        			displayWinner();
        	}
        	
    	} else {
    		//decide between altert and shuffle & deal
    		if(!autoShuffle) {
    			Alert alert = new Alert(AlertType.INFORMATION, "please shuffle first");
                alert.setTitle("not enought cards");
                alert.showAndWait();
    		} else {
    			shuffle();
    			deal();
    		}
    	}
    }
    
    /**
    *getting the winner and set who wins and who not
    */
    private void displayWinner() {
    	Player winner = model.getPlayer(0);
    	for(int i = 1; i < PokerGame.NUM_PLAYERS; i++) {
    		winner = winner.getPlayerPane().evaluateWinner(model.getPlayer(i));
    	}
    	for(int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
    		if(!winner.getPlayerPane().equals(view.getPlayerPane(i))) {
    			view.getPlayerPane(i).setLblWins("loses");
    		} else {
    			winner.getPlayerPane().setLblWins("wins");
    	    	winner.getPlayerPane().animateWinnerLabel();
    		}
    	}
    }
    
    /**
    * Eventhandling for changing themes (red, green and grey)
    */
    private void changeColor(Event e) {
    	String fileName ="";
    	//changing the ID's for the correct CSS Styling
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
    	//setting the Image with the correct deck-color
    	Image image = new Image(this.getClass().getClassLoader().getResourceAsStream(
    														"poker/images/" + fileName));
		ImageView imv = new ImageView(image);
		//change values when changing CSS-Values!
		imv.setFitHeight(132);
		imv.setFitWidth(83);
		view.getDeckLabel().setGraphic(imv);
    }
    
    /**
     * Eventhandling for changing player number
     * gets corresponding MenuItem and sets NUmOfPlayer
     */
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
    	//reloads Model first
    	model.updateModel();
    	//relooads view after adn shuffles cards
		view.updateView(stage, model);
		shuffle();
    }
    
    /**
     * Eventhandling for the automatic shuffle
     * gets the corresponding MenuItem and sets Boolean
     */
    private void autoShuffle(Event s) {
    	if(s.getSource() == view.getAutoShuffleDisable()) {
    		this.autoShuffle = false;
    		
    	} else if(s.getSource() == view.getAutoShuffleEnable()) {
    		this.autoShuffle = true;
    	}	
    }
}
