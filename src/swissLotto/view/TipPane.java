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
	
	protected Button button = new Button("Zufallszahlen");
	protected TableView<LottoNumber> tableView;
	protected TableColumn<LottoNumber, String> colfirst;
	protected TableColumn<LottoNumber, String> colsecond;
	protected TableColumn<LottoNumber, String> colthird;
	protected TableColumn<LottoNumber, String> colfourth;
	protected TableColumn<LottoNumber, String> colfifth;
	protected TableColumn<LottoNumber, String> colsixth;
	protected TableColumn<LottoNumber, String> colluckyNr;
	

	public TipPane(Model model) {
		this.model = model;
		// Initialize TableView
		TableView<LottoNumber> tableView = createTableView();

		// Layout root pane
		
		this.setPadding(new Insets(10)); // around edge of VBox
		this.setSpacing(10); // between elements
		VBox.setVgrow(tableView, Priority.ALWAYS); // Vertical resize goes to the table
		this.getChildren().addAll(tableView, button);

		// Size constraints
		button.setMaxWidth(Double.MAX_VALUE); // button can grow horizontally
	}
	
	private TableView<LottoNumber> createTableView() {
		tableView = new TableView<>();
		tableView.setEditable(true);

		// Each column needs a title, and a source of data.
		// For editable columns, each column needs to contain a TextField.
		this.colfirst = new TableColumn<>("1.");
		this.colfirst.setCellFactory(TextFieldTableCell.forTableColumn());
		this.colfirst.setCellValueFactory(c -> c.getValue().getNumberProperty());
		tableView.getColumns().add(colfirst);

		this.colsecond = new TableColumn<>("2.");
		this.colsecond.setCellFactory(TextFieldTableCell.forTableColumn());
		this.colsecond.setCellValueFactory(c -> c.getValue().getNumber2());
		tableView.getColumns().add(colsecond);
		
		this.colthird = new TableColumn<>("3.");
		this.colthird.setCellFactory(TextFieldTableCell.forTableColumn());
		this.colthird.setCellValueFactory(c -> c.getValue().getNumber3());
		tableView.getColumns().add(colthird);
		
		this.colfourth = new TableColumn<>("4.");
		this.colfourth.setCellFactory(TextFieldTableCell.forTableColumn());
		this.colfourth.setCellValueFactory(c -> c.getValue().getNumber4());
		tableView.getColumns().add(colfourth);
		
		this.colfifth = new TableColumn<>("5.");
		this.colfifth.setCellFactory(TextFieldTableCell.forTableColumn());
		this.colfifth.setCellValueFactory(c -> c.getValue().getNumber5());
		tableView.getColumns().add(colfifth);
		
		this.colsixth = new TableColumn<>("6.");
		this.colsixth.setCellFactory(TextFieldTableCell.forTableColumn());
		this.colsixth.setCellValueFactory(c -> c.getValue().getNumber6());
		tableView.getColumns().add(colsixth);
		
		this.colluckyNr = new TableColumn<>("Glückszahl");
		this.colluckyNr.setCellFactory(TextFieldTableCell.forTableColumn());
		this.colluckyNr.setCellValueFactory(c -> c.getValue().getNumber7());
		tableView.getColumns().add(colluckyNr);

		// Finally, attach the tableView to the ObservableList of data
		tableView.setItems(model.getElements());

		return tableView;
	}

	public Button getButton() {
		return button;
	}

	public TableView<LottoNumber> getTableView() {
		return tableView;
	}

	public TableColumn<LottoNumber, String> getColfirst() {
		return colsecond;
	}
	
	public TableColumn<LottoNumber, String> getColsecond() {
		return colsecond;
	}

	public TableColumn<LottoNumber, String> getColthird() {
		return colthird;
	}

	public TableColumn<LottoNumber, String> getColfourth() {
		return colfourth;
	}

	public TableColumn<LottoNumber, String> getColfifth() {
		return colfifth;
	}

	public TableColumn<LottoNumber, String> getColsixth() {
		return colsixth;
	}

	public TableColumn<LottoNumber, String> getColluckyNr() {
		return colluckyNr;
	}
}
