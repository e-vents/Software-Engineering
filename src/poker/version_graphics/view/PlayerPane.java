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
    //only set winner to the screen: uses the evaluateWinner method from the model
    public void displayWinner(PlayerPane playerPane) {
    	
    	playerPane.lblWins.setText("Wins");
           	
    	for(int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
    		this.view.getPlayerPane(i).lblWins.setText("Loses");
        }
    }
    
    /*
    public void displayWinner() {
    	
    	for(int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
    		for(int j = 1; j < PokerGame.NUM_PLAYERS; j++) {
               	if(this.model.getPlayer(j-1).compareTo(this.model.getPlayer(i)) > 0) {
                   	this.lblWins.setText("Wins");
                   	this.view.getPlayerPane(j).lblWins.setText("Loses");
                   	
                } else {
                   	this.lblWins.setText("Loses");
                   	this.view.getPlayerPane(j).lblWins.setText("Wins ");
                }
               	/*
               	//tie-break
               	if(this.model.getPlayer(i-1).compareTo(this.model.getPlayer(i)) == 0) {
          			// if onePair
                	if(player.evaluateHand() == HandType.OnePair) {
                		ArrayList<Card> clist = HandType.getWinningCards();
                		for(Card c : clist) {
             				
                		}	
                	}
                }
                
    		}
    	}
    }
    */
    public void resetWinner() {
    	this.lblWins.setText("--");
    }
}
