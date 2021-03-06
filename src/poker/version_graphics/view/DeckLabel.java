package poker.version_graphics.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import poker.version_graphics.model.DeckOfCards;

public class DeckLabel extends Label {
	
	public DeckLabel() {
		super();
		this.getStyleClass().add("deck");
	}
	
	// Bind the label to the CardsRemaining property of the deck
	public void setDeck(DeckOfCards deck) {
		// setting numeric label part
		this.textProperty().bind(deck.getCardsRemainingProperty().asString());
		
		// setting graphic label part
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/reddeck.png"));
		ImageView imv = new ImageView(image);
		
		imv.setId("deckback");
		//change values when changing CSS-Values!
		imv.setFitHeight(132);
		imv.setFitWidth(83);
		
		this.setGraphic(imv);
	}
}
