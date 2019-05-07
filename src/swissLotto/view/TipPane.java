package swissLotto.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import swissLotto.model.Model;
import swissLotto.model.Tip;

public class TipPane extends VBox {
	private Model model;
	
	protected HBox buttons;
	protected Button addBtn = new Button("Tip hinzufügen");
	protected Button deleteBtn = new Button("Tip löschen");
	protected Button playBtn = new Button("Spielen");
	protected TableView<Tip> tableView;
	protected TableColumn<Tip, String> tip;
	protected TableColumn<Tip, String> firstCol;
	protected TableColumn<Tip, String> secondCol;
	protected TableColumn<Tip, String> thirdCol;
	protected TableColumn<Tip, String> fourthCol;
	protected TableColumn<Tip, String> fifthCol;
	protected TableColumn<Tip, String> sixthCol;
	protected TableColumn<Tip, String> luckyNumCol;
	

	public TipPane(Model model) {
		this.model = model;
		// Initialize TableView
		TableView<Tip> tableView = createTableView();
		buttons = new HBox();
		addBtn.setPrefWidth(250);
		addBtn.getStyleClass().add("controls");
		deleteBtn.setPrefWidth(250);
		deleteBtn.getStyleClass().add("controls");
		playBtn.setPrefWidth(78);
		playBtn.getStyleClass().add("controls");
		playBtn.setId("play");
		buttons.setSpacing(9);
		buttons.getChildren().addAll(deleteBtn, addBtn, playBtn);
		
		this.setPadding(new Insets(10)); // around edge of VBox
		this.setSpacing(10); // between elements
		VBox.setVgrow(tableView, Priority.ALWAYS); // Vertical resize goes to the table
		this.getChildren().addAll(tableView, buttons);
		this.setId("tipPane");
	}
	
	private TableView<Tip> createTableView() {
		tableView = new TableView<>();
		tableView.setEditable(true);

		// Each column needs a title, and a source of data.
		// For editable columns, each column needs to contain a TextField.
		this.tip = new TableColumn<>("Tip");
		this.tip.setCellFactory(TextFieldTableCell.forTableColumn());
		this.tip.setCellValueFactory(c -> c.getValue().getTipProperty());
		this.tip.setMaxWidth(35);
		tableView.getColumns().add(tip);
		
		this.firstCol = new TableColumn<>("1.");
		this.firstCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.firstCol.setCellValueFactory(c -> c.getValue().getNumberProperty(0));
		tableView.getColumns().add(firstCol);

		this.secondCol = new TableColumn<>("2.");
		this.secondCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.secondCol.setCellValueFactory(c -> c.getValue().getNumberProperty(1));
		tableView.getColumns().add(secondCol);
		
		this.thirdCol = new TableColumn<>("3.");
		this.thirdCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.thirdCol.setCellValueFactory(c -> c.getValue().getNumberProperty(2));
		tableView.getColumns().add(thirdCol);
		
		this.fourthCol = new TableColumn<>("4.");
		this.fourthCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.fourthCol.setCellValueFactory(c -> c.getValue().getNumberProperty(3));
		tableView.getColumns().add(fourthCol);
		
		this.fifthCol = new TableColumn<>("5.");
		this.fifthCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.fifthCol.setCellValueFactory(c -> c.getValue().getNumberProperty(4));
		tableView.getColumns().add(fifthCol);
		
		this.sixthCol = new TableColumn<>("6.");
		this.sixthCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.sixthCol.setCellValueFactory(c -> c.getValue().getNumberProperty(5));
		tableView.getColumns().add(sixthCol);
		
		this.luckyNumCol = new TableColumn<>("Glückszahl");
		this.luckyNumCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.luckyNumCol.setCellValueFactory(c -> c.getValue().getLuckyNumberProperty());
		tableView.getColumns().add(luckyNumCol);

		// Finally, attach the tableView to the ObservableList of data
		tableView.setItems(model.getTips());
		tableView.setMaxWidth(596);
		tableView.setMaxHeight(1000);

		return tableView;
	}

	public Button getAddBtn() {
		return this.addBtn;
	}
	public Button getDeleteBtn() {
		return this.deleteBtn;
	}

	public Button getPlayBtn() {
		return playBtn;
	}

	public TableView<Tip> getTableView() {
		return tableView;
	}

	public TableColumn<Tip, String> getFirstCol() {
		return firstCol;
	}
	
	public TableColumn<Tip, String> getSecondCol() {
		return secondCol;
	}

	public TableColumn<Tip, String> getThirdCol() {
		return thirdCol;
	}

	public TableColumn<Tip, String> getFourthCol() {
		return fourthCol;
	}

	public TableColumn<Tip, String> getFifthCol() {
		return fifthCol;
	}

	public TableColumn<Tip, String> getSixthCol() {
		return sixthCol;
	}

	public TableColumn<Tip, String> getLuckyNumCol() {
		return luckyNumCol;
	}
}
