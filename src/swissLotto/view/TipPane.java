package swissLotto.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import swissLotto.model.Model;
import swissLotto.model.LottoNumber;

public class TipPane extends VBox {
	private Model model;
	
	protected Button addBtn = new Button("Tip hinzufügen");
	protected Button deleteBtn = new Button("Tip löschen");
	protected TableView<LottoNumber> tableView;
	protected TableColumn<LottoNumber, String> tip;
	protected TableColumn<LottoNumber, String> firstCol;
	protected TableColumn<LottoNumber, String> secondCol;
	protected TableColumn<LottoNumber, String> thirdCol;
	protected TableColumn<LottoNumber, String> fourthCol;
	protected TableColumn<LottoNumber, String> fifthCol;
	protected TableColumn<LottoNumber, String> sixthCol;
	protected TableColumn<LottoNumber, String> luckyNumCol;
	

	public TipPane(Model model) {
		this.model = model;
		// Initialize TableView
		TableView<LottoNumber> tableView = createTableView();

		// Layout root pane
		
		this.setPadding(new Insets(10)); // around edge of VBox
		this.setSpacing(10); // between elements
		VBox.setVgrow(tableView, Priority.ALWAYS); // Vertical resize goes to the table
		this.getChildren().addAll(tableView, addBtn, deleteBtn);

		// Size constraints
		addBtn.setMaxWidth(597); // button can grow horizontally
		deleteBtn.setMaxWidth(597);
	}
	
	private TableView<LottoNumber> createTableView() {
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
		this.firstCol.setCellValueFactory(c -> c.getValue().getNumber());
		tableView.getColumns().add(firstCol);

		this.secondCol = new TableColumn<>("2.");
		this.secondCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.secondCol.setCellValueFactory(c -> c.getValue().getNumber2());
		tableView.getColumns().add(secondCol);
		
		this.thirdCol = new TableColumn<>("3.");
		this.thirdCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.thirdCol.setCellValueFactory(c -> c.getValue().getNumber3());
		tableView.getColumns().add(thirdCol);
		
		this.fourthCol = new TableColumn<>("4.");
		this.fourthCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.fourthCol.setCellValueFactory(c -> c.getValue().getNumber4());
		tableView.getColumns().add(fourthCol);
		
		this.fifthCol = new TableColumn<>("5.");
		this.fifthCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.fifthCol.setCellValueFactory(c -> c.getValue().getNumber5());
		tableView.getColumns().add(fifthCol);
		
		this.sixthCol = new TableColumn<>("6.");
		this.sixthCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.sixthCol.setCellValueFactory(c -> c.getValue().getNumber6());
		tableView.getColumns().add(sixthCol);
		
		this.luckyNumCol = new TableColumn<>("Glückszahl");
		this.luckyNumCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.luckyNumCol.setCellValueFactory(c -> c.getValue().getLuckyNumber());
		tableView.getColumns().add(luckyNumCol);

		// Finally, attach the tableView to the ObservableList of data
		tableView.setItems(model.getElements());
		tableView.setMaxWidth(597);

		return tableView;
	}

	public Button getAddBtn() {
		return this.addBtn;
	}
	public Button getDeleteBtn() {
		return this.deleteBtn;
	}

	public TableView<LottoNumber> getTableView() {
		return tableView;
	}

	public TableColumn<LottoNumber, String> getFirstCol() {
		return firstCol;
	}
	
	public TableColumn<LottoNumber, String> getSecondCol() {
		return secondCol;
	}

	public TableColumn<LottoNumber, String> getThirdCol() {
		return thirdCol;
	}

	public TableColumn<LottoNumber, String> getFourthCol() {
		return fourthCol;
	}

	public TableColumn<LottoNumber, String> getFifthCol() {
		return fifthCol;
	}

	public TableColumn<LottoNumber, String> getSixthCol() {
		return sixthCol;
	}

	public TableColumn<LottoNumber, String> getLuckyNumCol() {
		return luckyNumCol;
	}
}
