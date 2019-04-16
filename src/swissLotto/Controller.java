package swissLotto;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import swissLotto.model.Model;
import swissLotto.model.LottoNumber;
import swissLotto.view.View;

public class Controller {
	final private Model model;
	final private View view;
	
	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
		
		view.getTipPane().getButton().setOnAction(e -> model.addNewNumber());
		
		// Event handlers for the table columns: validate user input
		view.getTipPane().getColfirst().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getColsecond().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getColthird().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getColfourth().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getColfifth().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getColsixth().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getColluckyNr().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumberValid(newValue))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
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
		model.getElements().addListener((ListChangeListener<LottoNumber>) c -> {
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

	private LottoNumber getLottoNumberFromEvent(CellEditEvent<LottoNumber, String> editEvent) {
		TableView<LottoNumber> tv = editEvent.getTableView();
		int rowNumber = editEvent.getTablePosition().getRow();
		return tv.getItems().get(rowNumber);
	}
}