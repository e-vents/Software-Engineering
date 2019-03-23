package poker.version_graphics.view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import poker.version_graphics.PokerGame;
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
    // added for testing reasons
    private PokerGameModel model;
    private PokerGameView view;
    
    public PlayerPane(PokerGameModel model, PokerGameView view) {
        super(); // Always call super-constructor first !
        // added for testing reasons
        this.model = model;
        this.view = view;
        
        this.getStyleClass().add("player"); // CSS style class
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
    	updatePlayerDisplay(); // Immediately display the player information
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
    /*
     * will be called from the controller
     * this method should call the isWinner-method from the player class
     */
    public void displayWinner(Player nextPlayer) {
    	
    	if(player.compareTo(nextPlayer) > 0)
    		this.lblWins.setText("wins");
    		
    	else if(player.compareTo(nextPlayer) < 0)
    		this.lblWins.setText("loses");
    	
    	else
    		tieBreak(nextPlayer);
    }
    private void tieBreak(Player nextPlayer) {
    	
    	if(player.evaluateHand() == HandType.HighCard) {
    		highCardMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.OnePair) {
    		onePairMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.TwoPair) {
    		twoPairMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.ThreeOfAKind) {
    		threeOfAKindMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.Straight) {
    		straightMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.FullHouse) {
    		fullHouseMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.Flush) {
    		flushMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.StraightFlush) {
    		straightFlushMatch(nextPlayer);
    		
    	}
    	
    }
    private void straightFlushMatch(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	private void flushMatch(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	private void fullHouseMatch(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	private void straightMatch(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	private void threeOfAKindMatch(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	private void twoPairMatch(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	private void onePairMatch(Player nextPlayer) {
		if(player.getPairCard().compareTo(nextPlayer.getPairCard()) > 0)
			this.lblWins.setText("wins");
		else if(player.getPairCard().compareTo(nextPlayer.getPairCard()) < 0)
			this.lblWins.setText("loses");
		else
			if(player.getHighestCard(player.getPairCard()).compareTo(
					nextPlayer.getHighestCard(nextPlayer.getPairCard())) > 0)
				this.lblWins.setText("winds");
		
	}

	//add methods; highCardsMatch, OnePairMatch, TwoPairMatch
    private void highCardMatch(Player nextPlayer) {
    	if(player.getHighestCard().compareTo(nextPlayer.getHighestCard()) > 0)
			this.lblWins.setText("wins");
			
		else if(player.getHighestCard().compareTo(nextPlayer.getHighestCard()) < 0)
			this.lblWins.setText("loses");
		else {
			if(player.getSecondHighestCard().compareTo(nextPlayer.getSecondHighestCard()) > 0)
    			this.lblWins.setText("wins");
			else if(player.getSecondHighestCard().compareTo(nextPlayer.getSecondHighestCard()) < 0)
				this.lblWins.setText("loses");
			else {
				if(player.getThirdHighestCard().compareTo(nextPlayer.getThirdHighestCard()) > 0)
        			this.lblWins.setText("wins");
    			else if(player.getThirdHighestCard().compareTo(nextPlayer.getThirdHighestCard()) < 0)
    				this.lblWins.setText("loses");
    			else {
    				if(player.getFourthHighestCard().compareTo(nextPlayer.getFourthHighestCard()) > 0)
    					this.lblWins.setText("wins");
    				else if(player.getFourthHighestCard().compareTo(nextPlayer.getFourthHighestCard()) < 0)
    					this.lblWins.setText("loses");
    				else {
    					if(player.getLowestCard().compareTo(nextPlayer.getLowestCard()) > 0)
    						this.lblWins.setText("wins");
    					else if(player.getLowestCard().compareTo(nextPlayer.getLowestCard()) < 0)
    						this.lblWins.setText("loses");
    				}
    			}
			}
		}
    }
    
    
    public void resetWinner() {
    	this.lblWins.setText("--");
    }
}
