package swissLotto.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import swissLotto.model.Drawing;
import swissLotto.model.SuperNumber;

public class TipPane extends VBox {
	private Drawing drawing;
	
	protected Button button = new Button("Zufallszahlen");
	protected TableView<SuperNumber> tableView;
	protected TableColumn<SuperNumber, String> colfirst;
	protected TableColumn<SuperNumber, String> colsecond;
	protected TableColumn<SuperNumber, String> colthird;
	protected TableColumn<SuperNumber, String> colfourth;
	protected TableColumn<SuperNumber, String> colfifth;
	protected TableColumn<SuperNumber, String> colsixth;
	protected TableColumn<SuperNumber, String> colluckyNr;
	

	public TipPane(Drawing drawing) {
		this.drawing = drawing;
		// Initialize TableView
		TableView<SuperNumber> tableView = createTableView();

		// Layout root pane
		
		this.setPadding(new Insets(10)); // around edge of VBox
		this.setSpacing(10); // between elements
		VBox.setVgrow(tableView, Priority.ALWAYS); // Vertical resize goes to the table
		this.getChildren().addAll(tableView, button);

		// Size constraints
		button.setMaxWidth(Double.MAX_VALUE); // button can grow horizontally
	}
	
	private TableView<SuperNumber> createTableView() {
		tableView = new TableView<>();
		tableView.setEditable(true);

		// Each column needs a title, and a source of data.
		// For editable columns, each column needs to contain a TextField.
		this.colfirst = new TableColumn<>("1.");
		this.colfirst.setCellFactory(TextFieldTableCell.forTableColumn());
		//this.colfirst.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colfirst);

		this.colsecond = new TableColumn<>("2.");
		this.colsecond.setCellFactory(TextFieldTableCell.forTableColumn());
		//this.colfirst.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colsecond);
		
		this.colthird = new TableColumn<>("3.");
		this.colthird.setCellFactory(TextFieldTableCell.forTableColumn());
		//this.colfirst.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colthird);
		
		this.colfourth = new TableColumn<>("4.");
		this.colfourth.setCellFactory(TextFieldTableCell.forTableColumn());
		//this.colfirst.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colfourth);
		
		this.colfifth = new TableColumn<>("5.");
		this.colfifth.setCellFactory(TextFieldTableCell.forTableColumn());
		//this.colfirst.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colfifth);
		
		this.colsixth = new TableColumn<>("6.");
		this.colsixth.setCellFactory(TextFieldTableCell.forTableColumn());
		//this.colfirst.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colsixth);
		
		this.colluckyNr = new TableColumn<>("Glückszahl");
		this.colluckyNr.setCellFactory(TextFieldTableCell.forTableColumn());
		//this.colfirst.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colluckyNr);

		// Finally, attach the tableView to the ObservableList of data
		tableView.setItems(drawing.getElements());

		return tableView;
	}

	public Button getButton() {
		return button;
	}
	

	public TableView<SuperNumber> getTableView() {
		return tableView;
	}

	public TableColumn<SuperNumber, String> getColfirst() {
		return colsecond;
	}
	
	public TableColumn<SuperNumber, String> getColsecond() {
		return colsecond;
	}

	public TableColumn<SuperNumber, String> getColthird() {
		return colthird;
	}

	public TableColumn<SuperNumber, String> getColfourth() {
		return colfourth;
	}

	public TableColumn<SuperNumber, String> getColfifth() {
		return colfifth;
	}

	public TableColumn<SuperNumber, String> getColsixth() {
		return colsixth;
	}

	public TableColumn<SuperNumber, String> getColluckyNr() {
		return colluckyNr;
	}
	
}
