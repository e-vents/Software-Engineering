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
    //private PokerGameModel model;
    //private PokerGameView view;
    
    public PlayerPane(PokerGameModel model, PokerGameView view) {
        super(); // Always call super-constructor first !
        //this.model = model;
        // this.view = view;
        
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
    
    /*
     * will be called from the controller
     * this method should call the isWinner-method from the player class
     */
    public void displayWinner(Player nextPlayer) {
    	
    	if(player.compareTo(nextPlayer) > 0) {
    		this.lblWins.setText("wins");
        	animateWinnerLabel();
    	}
    	else if(player.compareTo(nextPlayer) < 0)
    		this.lblWins.setText("loses");
    	
    	else
    		tieBreak(nextPlayer);
    }
    private void tieBreak(Player nextPlayer) {
    	
    	if(player.evaluateHand() == HandType.HighCard 
    		|| player.evaluateHand() == HandType.Straight 
    		|| player.evaluateHand() == HandType.Flush 
    		|| player.evaluateHand() == HandType.StraightFlush) {
    		highCardMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.OnePair) {
    		onePairMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.TwoPair) {
    		twoPairMatch(nextPlayer);
    		
    	} else if(player.evaluateHand() == HandType.ThreeOfAKind 
    			|| player.evaluateHand() == HandType.FullHouse) {
    		threeOfAKindMatch(nextPlayer);	
    	}
    }
	
	private void threeOfAKindMatch(Player nextPlayer) {
		if(player.getThreeOfAKindCard().compareTo(nextPlayer.getThreeOfAKindCard()) > 0) {
			this.lblWins.setText("wins");
			animateWinnerLabel();
		}
		else //if(player.getThreeOfAKindCard().compareTo(nextPlayer.getThreeOfAKindCard()) > 0)
			this.lblWins.setText("loses");
	}
	
	private void twoPairMatch(Player nextPlayer) {
		if(player.getHigherPairCard().compareTo(nextPlayer.getHigherPairCard()) > 0) {
			this.lblWins.setText("wins");
    		animateWinnerLabel();
		}
		else if(player.getHigherPairCard().compareTo(nextPlayer.getHigherPairCard()) < 0)
			this.lblWins.setText("loses");
		else {
			if(player.getLowerPairCard().compareTo(nextPlayer.getLowerPairCard()) > 0) {
				this.lblWins.setText("wins");
	    		animateWinnerLabel();
			}
			else if(player.getLowerPairCard().compareTo(nextPlayer.getLowerPairCard()) < 0)
				this.lblWins.setText("loses");
		}
	}
	
	private void onePairMatch(Player nextPlayer) {
		if(player.getPairCard().compareTo(nextPlayer.getPairCard()) > 0) {
			this.lblWins.setText("wins");
    		animateWinnerLabel();
		}
		else if(player.getPairCard().compareTo(nextPlayer.getPairCard()) < 0)
			this.lblWins.setText("loses");
		else {//when pairs are equal
			if(player.getHighestCard(player.getPairCard()).compareTo(
							nextPlayer.getHighestCard(nextPlayer.getPairCard())) > 0) {
				this.lblWins.setText("wins");
	    		animateWinnerLabel();
			}
			else if(player.getHighestCard(player.getPairCard()).compareTo(
								nextPlayer.getHighestCard(nextPlayer.getPairCard())) < 0)
				this.lblWins.setText("loses");
			else {
				if(player.getSecondHighestCard(player.getPairCard()).compareTo(
								nextPlayer.getSecondHighestCard(nextPlayer.getPairCard())) > 0) {
					this.lblWins.setText("wins");
					animateWinnerLabel();
				}
    			else if(player.getSecondHighestCard(player.getPairCard()).compareTo(
    								nextPlayer.getSecondHighestCard(nextPlayer.getPairCard())) < 0)
    				this.lblWins.setText("loses");
    			else {
    				if(player.getThirdHighestCard(player.getPairCard()).compareTo(
    								nextPlayer.getThirdHighestCard(nextPlayer.getPairCard())) > 0) {
    					this.lblWins.setText("wins");
    					animateWinnerLabel();
    				}
    				else if(player.getThirdHighestCard(player.getPairCard()).compareTo(
    									nextPlayer.getThirdHighestCard(nextPlayer.getPairCard())) < 0)
    					this.lblWins.setText("loses");
    				else {
    					if(player.getFourthHighestCard(player.getPairCard()).compareTo(
    									nextPlayer.getFourthHighestCard(nextPlayer.getPairCard())) > 0) {
    						this.lblWins.setText("wins");
    						animateWinnerLabel();
    					}
        				else if(player.getFourthHighestCard(player.getPairCard()).compareTo(
        									nextPlayer.getFourthHighestCard(nextPlayer.getPairCard())) < 0)
        					this.lblWins.setText("loses");
    				}
    			}
			}
		}
	}	
	
    private void highCardMatch(Player nextPlayer) {
    	if(player.getHighestCard().compareTo(nextPlayer.getHighestCard()) > 0) {
    		this.lblWins.setText("wins");
    		animateWinnerLabel();
    	}
		else if(player.getHighestCard().compareTo(nextPlayer.getHighestCard()) < 0)
			this.lblWins.setText("loses");
		else {//when high cards are equal
			if(player.getSecondHighestCard().compareTo(nextPlayer.getSecondHighestCard()) > 0) {
				this.lblWins.setText("wins");
	    		animateWinnerLabel();
			}
			else if(player.getSecondHighestCard().compareTo(nextPlayer.getSecondHighestCard()) < 0)
				this.lblWins.setText("loses");
			else {
				if(player.getThirdHighestCard().compareTo(nextPlayer.getThirdHighestCard()) > 0) {
					this.lblWins.setText("wins");
		    		animateWinnerLabel();
				}
    			else if(player.getThirdHighestCard().compareTo(nextPlayer.getThirdHighestCard()) < 0)
    				this.lblWins.setText("loses");
    			else {
    				if(player.getFourthHighestCard().compareTo(nextPlayer.getFourthHighestCard()) > 0) {
    					this.lblWins.setText("wins");
    		    		animateWinnerLabel();
    				}
    				else if(player.getFourthHighestCard().compareTo(nextPlayer.getFourthHighestCard()) < 0)
    					this.lblWins.setText("loses");
    				else {
    					if(player.getLowestCard().compareTo(nextPlayer.getLowestCard()) > 0) {
    						this.lblWins.setText("wins");
    			    		animateWinnerLabel();
    					}
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
