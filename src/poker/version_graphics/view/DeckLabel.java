package poker.version_graphics.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import poker.version_graphics.model.DeckOfCards;

public class DeckLabel extends Label {
	
	protected String fileName;
	
	public DeckLabel() {
		super();
		this.getStyleClass().add("deck");
	}
	
	// Bind the label to the CardsRemaining property of the deck
	public void setDeck(DeckOfCards deck) {
		this.textProperty().bind(deck.getCardsRemainingProperty().asString());
		
		this.fileName = "deckback.png";
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/" + fileName));
		ImageView imv = new ImageView(image);
		
		imv.setId("deckcards");
		
		imv.setFitHeight(185);
		imv.setFitWidth(122);
		/*
		imv.fitWidthProperty().bind(this.widthProperty());
		imv.fitHeightProperty().bind(this.heightProperty());
		imv.setPreserveRatio(true);
		*/
		this.setGraphic(imv);
	}
}
