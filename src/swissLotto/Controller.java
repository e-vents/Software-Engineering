package swissLotto;

import javafx.collections.ListChangeListener;
import javafx.event.Event;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import swissLotto.model.Drawing;
import swissLotto.model.SuperNumber;
import swissLotto.view.View;

public class Controller {
	final private Drawing drawing;
	final private View view;
	
	public Controller(Drawing drawing, View view) {
		this.view = view;
		this.drawing = drawing;
		
		view.getTipPane().getButton().setOnAction(e -> drawing.addNewElement());
		
		// Event handlers for the table columns: validate user input
		view.getTipPane().getColfirst().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getSuperNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});

		// Event handler for the model's ObservableList requires a
		// ListChangeListener, which is generic, so we have to cast our lambda
		// to fill in the type.
		//
		// ListChangeListener provides a list of events, so we must provide
		// a loop in case multiple changes are pending. We only want to scroll
		// to the position of the last change made.
		drawing.getElements().addListener((ListChangeListener<SuperNumber>) c -> {
			while (c.next()) {
				view.getTipPane().getTableView().scrollTo(c.getFrom());
			}
		});
	}

	private boolean isNumberValid(String number) {
		boolean valid;
		try {
			Integer.parseInt(number);
			valid = true;
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;
	}

	private SuperNumber getSuperNumberFromEvent(CellEditEvent<SuperNumber, String> editEvent) {
		TableView<SuperNumber> tv = editEvent.getTableView();
		int rowNumber = editEvent.getTablePosition().getRow();
		return tv.getItems().get(rowNumber);
	}
}