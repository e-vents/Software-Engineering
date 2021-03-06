package poker.version_graphics.view;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.HandType;
import poker.version_graphics.model.Player;
import poker.version_graphics.model.PokerGameModel;

public class PlayerPane extends VBox {
    private Label lblName = new Label();
    private HBox hboxCards = new HBox();
    private Label lblEvaluation = new Label("--");
    private Label lblWins = new Label("--");
       
    // Link to player object
    private Player player;
    
    public PlayerPane(PokerGameModel model, PokerGameView view) {
        super(); // Always call super-constructor first !
        
        this.getStyleClass().add("player"); // CSS style classes
        this.lblName.getStyleClass().add("labels");
        this.lblWins.getStyleClass().add("labels");
        this.lblEvaluation.getStyleClass().add("labels");
        
        // Add child nodes
        this.getChildren().addAll(lblName, hboxCards, lblEvaluation, lblWins);
        
        
        // Add CardLabels for the cards
        for (int i = 0; i < 5; i++) {
            Label lblCard = new CardLabel(); 
            hboxCards.getChildren().add(lblCard);
            hboxCards.setSpacing(5.0);
        }
    }
    
    public void setPlayer(Player player) {
    	this.player = player;
    	player.setPlayerPane(this);
    	updatePlayerDisplay(); // Immediately display the player information
    }
    
    public Player getPlayer() {
    	return this.player;
    }
    
    public void updatePlayerDisplay() {
    	lblName.setText(player.getPlayerName());
    	for (int i = 0; i < Player.HAND_SIZE; i++) {
    		Card card = null;
    		if (player.getCards().size() > i) card = player.getCards().get(i);
    		CardLabel cl = (CardLabel) hboxCards.getChildren().get(i);
    		cl.setCard(card);
    		HandType evaluation = player.evaluateHand();
    		if (evaluation != null)
    			lblEvaluation.setText(evaluation.toString());
    		else
    			lblEvaluation.setText("--");
    	}
    }
    /**
     * defines a scale and a rotate transisiton
     */
    public void animateWinnerLabel() {
    	ScaleTransition scale = new ScaleTransition(Duration.millis(250));
    	scale.setToX(2);
    	scale.setToY(2);
    	scale.setAutoReverse(true);
    	scale.setCycleCount(4);
    	
    	RotateTransition turn = new RotateTransition(Duration.millis(500));
    	turn.setByAngle(360);
    	turn.setCycleCount(1);
		
    	ParallelTransition winner = new ParallelTransition(scale, turn);
    	//Event-handler
    	winner.setNode(lblWins);
    	winner.play();
    }
    
    /**
     * return the winner or calls tiebreak-method
     * will be called from the controller
     */
    public Player evaluateWinner(Player nextPlayer) {
    	
    	if(player.compareTo(nextPlayer) > 0) {
    		return this.player;
    	}
    	else if(player.compareTo(nextPlayer) < 0) {
    		return nextPlayer;
    	}
    	else
    		return tieBreak(nextPlayer);
    }
    /**
     * sorts Hands which can be handled together
     * and then calls the requested ...Match-method
     */
    private Player tieBreak(Player nextPlayer) {
    	
    	if(player.evaluateHand() == HandType.HighCard 
    		|| player.evaluateHand() == HandType.Straight 
    		|| player.evaluateHand() == HandType.Flush 
    		|| player.evaluateHand() == HandType.StraightFlush) {
    		return highCardMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.OnePair) {
    		return onePairMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.TwoPair) {
    		return twoPairMatch(nextPlayer);
    		
    	} else //covers also FullHouse and FourOfAKind
    		return threeOfAKindMatch(nextPlayer);	
    }
	/**
	 * the following method are used for tie-break evaluation
     * they return the the winner
	 */
	private Player threeOfAKindMatch(Player nextPlayer) {
		//check which player has the higher three of a kind
		if(player.getThreeOfAKindCard().compareTo(nextPlayer.getThreeOfAKindCard()) > 0) {
			return this.player;
		}
		else
			return nextPlayer;
	}
	
	private Player twoPairMatch(Player nextPlayer) {
		//check for equality on the higher pair
		if(player.getHigherPairCard().compareTo(
			nextPlayer.getHigherPairCard()) > 0) {
			return this.player;
		}
		else if(player.getHigherPairCard().compareTo(
				nextPlayer.getHigherPairCard()) < 0)
			return nextPlayer;
		
		else { //check for equality on the lower pair
			if(player.getLowerPairCard().compareTo(
				nextPlayer.getLowerPairCard()) > 0) {
				return this.player;
			}
			else
				return nextPlayer;
		}
	}
	
	private Player onePairMatch(Player nextPlayer) {
		//check for equality on the first level
		if(player.getPairCard().compareTo(nextPlayer.getPairCard()) > 0) 
			return this.player;
		
		else if(player.getPairCard().compareTo(nextPlayer.getPairCard()) < 0)
			return nextPlayer;
		
		else  //when pair is equal: compares the highest card left
			if(player.getHighestCard(player.getPairCard()).compareTo(
					nextPlayer.getHighestCard(nextPlayer.getPairCard())) > 0) 
				return this.player;
		
			else if(player.getHighestCard(player.getPairCard()).compareTo(
					nextPlayer.getHighestCard(nextPlayer.getPairCard())) < 0)
				return nextPlayer;
		
			else  //compares the second highest card left
				if(player.getSecondHighestCard(player.getPairCard()).compareTo(
						nextPlayer.getSecondHighestCard(nextPlayer.getPairCard())) > 0) 
					return this.player;
				
    			else if(player.getSecondHighestCard(player.getPairCard()).compareTo(
    					nextPlayer.getSecondHighestCard(nextPlayer.getPairCard())) < 0)
    				return nextPlayer;
		
    			else //compares the thir third highest card left
    				if(player.getThirdHighestCard(player.getPairCard()).compareTo(
    						nextPlayer.getThirdHighestCard(nextPlayer.getPairCard())) > 0) 
    					return this.player;
    				
    				else 
    					return nextPlayer;
	}
		
	
    private Player highCardMatch(Player nextPlayer) {
    	//check for equality on the first level
    	if(player.getHighestCard().compareTo(
    			nextPlayer.getHighestCard()) > 0) 
    		return this.player;
    	
		else if(player.getHighestCard().compareTo(
				nextPlayer.getHighestCard()) < 0)
			return nextPlayer;
    	
		else //when high cards are equal compares the second highest card
			if(player.getSecondHighestCard().compareTo(
					nextPlayer.getSecondHighestCard()) > 0) 
				return this.player;
			
			else if(player.getSecondHighestCard().compareTo(
					nextPlayer.getSecondHighestCard()) < 0)
				return nextPlayer;
    	
			else //compares the third highest card
				if(player.getThirdHighestCard().compareTo(
						nextPlayer.getThirdHighestCard()) > 0) 
					return this.player;
				
    			else if(player.getThirdHighestCard().compareTo(
    					nextPlayer.getThirdHighestCard()) < 0)
    				return nextPlayer;
    	
    			else //compares the fourth highest card
    				if(player.getFourthHighestCard().compareTo(
    						nextPlayer.getFourthHighestCard()) > 0)
    					return this.player;
    	
    				else if(player.getFourthHighestCard().compareTo(
    						nextPlayer.getFourthHighestCard()) < 0)
    					return nextPlayer;
    	
    				else //compares the lowest card
    					if(player.getLowestCard().compareTo(
    							nextPlayer.getLowestCard()) > 0)
    						return this.player;		
    					else
    						return nextPlayer;
    }
    
    public void resetWinner() {
    	this.lblWins.setText("--");
    }
    
    public void setLblWins(String s) {
    	this.lblWins.setText(s);
    }
}
