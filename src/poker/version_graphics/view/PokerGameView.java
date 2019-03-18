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
	private BorderPane root;
	private HBox players;
	private ControlArea controls;
	private MenuBar menuBar;
	private Menu styleMenu;
	private MenuItem greenItem;
	private MenuItem redItem;
	private Menu playerMenu;
	
	private PokerGameModel model;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane(this.model, this);
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
			players.setSpacing(20);
		}
		
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		//create the top-menu
		menuBar = new MenuBar();
		
		this.greenItem = new MenuItem("green");
		this.redItem = new MenuItem("red");
		styleMenu = new Menu("Background");
		styleMenu.getItems().addAll(greenItem, redItem);
		
		MenuItem p1 = new MenuItem("2");
		MenuItem p2 = new MenuItem("3");
		MenuItem p3 = new MenuItem("4");
		playerMenu = new Menu("player");
		playerMenu.getItems().addAll(p1, p2, p3);
		
		menuBar.getMenus().addAll(styleMenu, playerMenu);
		//menu.getStyleClass().add("menu");
		styleMenu.getStyleClass().add("menu");
		playerMenu.getStyleClass().add("menu");
		
		greenItem.getStyleClass().add("menu");
		redItem.getStyleClass().add("menu");
		p1.getStyleClass().add("menu");
		p2.getStyleClass().add("menu");
		p3.getStyleClass().add("menu");
		
		// Put players and controls into a BorderPane
		this.root = new BorderPane();
		root.setCenter(players);
		root.setBottom(controls);
		root.setTop(menuBar);
		
		// Disallow resizing - which is difficult to get right with images
		//stage.setResizable(false);

        // Create the scene using our layout; then display it
        Scene scene = new Scene(root, 1300, 520);
        scene.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Master 5000");
        stage.setScene(scene);
        stage.show();		
	}
	
	public BorderPane getRoot() {
		return root;
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
	public MenuItem getRedItem() {
		return this.redItem;
	}
	public MenuItem getGreenItem() {
		return this.greenItem;
	}
	public ControlArea getControls() {
		return controls;
	}
	public void setFileName(String name) {
		this.controls.setFileName(name);
	}
}
