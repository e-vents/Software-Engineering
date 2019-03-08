package poker.version_graphics.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.PokerGameModel;

public class PokerGameView {
	private HBox players;
	private ControlArea controls;
	private MenuBar menu;
	private Menu style;
	private Menu player;
	
	private PokerGameModel model;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
			players.setSpacing(20);
		}
		
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		//create the top-menu
		menu = new MenuBar();
		
		MenuItem b1 = new MenuItem("green");
		MenuItem b2 = new MenuItem("red");
		style = new Menu("Background");
		style.getItems().addAll(b1, b2);
		
		MenuItem p1 = new MenuItem("2");
		MenuItem p2 = new MenuItem("3");
		MenuItem p3 = new MenuItem("4");
		player = new Menu("player");
		player.getItems().addAll(p1, p2, p3);
		
		menu.getMenus().addAll(style, player);
		//menu.getStyleClass().add("menu");
		style.getStyleClass().add("menu");
		player.getStyleClass().add("menu");
		b1.getStyleClass().add("menu");
		b2.getStyleClass().add("menu");
		p1.getStyleClass().add("menu");
		p2.getStyleClass().add("menu");
		p3.getStyleClass().add("menu");
		
		// Put players and controls into a BorderPane
		BorderPane root = new BorderPane();
		root.setCenter(players);
		root.setBottom(controls);
		root.setTop(menu);
		
		// Disallow resizing - which is difficult to get right with images
		//stage.setResizable(false);

        // Create the scene using our layout; then display it
        Scene scene = new Scene(root, 1150, 400);
        scene.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Master 5000");
        stage.setScene(scene);
        stage.show();		
	}
	
	public PlayerPane getPlayerPane(int i) {
		return (PlayerPane) players.getChildren().get(i);
	}
	
	public Button getShuffleButton() {
		return controls.btnShuffle;
	}
	
	public Button getDealButton() {
		return controls.btnDeal;
	}
}
