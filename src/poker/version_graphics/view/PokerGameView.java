package poker.version_graphics.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.PokerGameModel;

public class PokerGameView {
	private BorderPane root;
	private GridPane players;
	private ControlArea controls;
	private MenuBar menuBar;
	private Menu styleMenu;
	private MenuItem greenItem;
	private MenuItem redItem;
	private MenuItem greyItem;
	private Menu playerMenu;
	private MenuItem twoPlayer;
	private MenuItem threePlayer;
	private MenuItem fourPlayer;
	
	private PokerGameModel model;
	
	private Scene scene;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new GridPane();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane(this.model, this);
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			
			if(i == 0)
				players.add(pp, 0, 0);
			else
				players.add(pp, 2, 0);
		}
		
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		//create the top-menu
		menuBar = new MenuBar();
		//theme menu
		this.greenItem = new MenuItem("GreenBean");
		this.redItem = new MenuItem("RustyDusty");
		this.greyItem = new MenuItem("MouseHouse");
		styleMenu = new Menu("themes");
		styleMenu.getItems().addAll(greenItem, redItem, greyItem);
		
		//players menu
		this.twoPlayer = new MenuItem("2 player");
		this.threePlayer = new MenuItem("3 player");
		this.fourPlayer = new MenuItem("4 player");
		playerMenu = new Menu("players");
		playerMenu.getItems().addAll(twoPlayer, threePlayer, fourPlayer);
		
		menuBar.getMenus().addAll(styleMenu, playerMenu);
		//menu.getStyleClass().add("menu");
		styleMenu.getStyleClass().add("menu");
		playerMenu.getStyleClass().add("menu");
		
		greenItem.getStyleClass().add("menu");
		redItem.getStyleClass().add("menu");
		this.twoPlayer.getStyleClass().add("menu");
		this.threePlayer.getStyleClass().add("menu");
		this.fourPlayer.getStyleClass().add("menu");
		
		// Put players and controls into a BorderPane
		this.root = new BorderPane();
		root.setCenter(players);
		root.setBottom(controls);
		root.setTop(menuBar);
		
		// Disallow resizing - which is difficult to get right with images
		//stage.setResizable(false);

        // Create the scene using our layout; then display it
        this.scene = new Scene(root, 890, 450);
        scene.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Master 5000");
        stage.getIcons().add(new Image("poker/images/poker-icon.png"));
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
	//Getter for themes Items
	public MenuItem getRedItem() {
		return this.redItem;
	}
	public MenuItem getGreenItem() {
		return this.greenItem;
	}
	public MenuItem getGreyItem() {
		return this.greyItem;
	}
	//Getters for player Items
	public MenuItem getTwoPlayer() {
		return twoPlayer;
	}
	public MenuItem getThreePlayer() {
		return threePlayer;
	}
	public MenuItem getFourPlayer() {
		return fourPlayer;
	}

	public ControlArea getControls() {
		return controls;
	}
	
	public DeckLabel getDeckLabel() {
		return this.controls.getDeckLabel();
	}
	
	public void updateView(Stage stage, PokerGameModel model) {
		this.model = model;
		
		// Create all of the player panes we need, and put them into an HBox
		players.getChildren().clear();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane(this.model, this);
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			if(i == 0) {
				players.add(pp, 0, 0);
				
			} else if(i == 1) {
				players.add(pp, 2, 0);
				
			} else if(i == 2) {
				players.add(pp, 0, 1);
				
			} else {
				players.add(pp, 2, 1);
			}
		}
		//setting adaptive scene for more than 2 players
		if(players.getChildren().size() < 3)
			this.scene.getWindow().setHeight(450);
		else
			this.scene.getWindow().setHeight(670);
		
		
		scene.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Master 5000");
        stage.getIcons().add(new Image("poker/images/poker-icon.png"));
        
        stage.setScene(scene);
        stage.show();
        
	}
}
