package swissLotto;

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
		
		view.getTipPane().getAddBtn().setOnAction(e -> model.addNewNumber());
		view.getTipPane().getDeleteBtn().setOnAction(e -> model.deleteNumber());
		
		// Event handlers for the table columns: validate user input
		view.getTipPane().getFirstCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getLottoNumberFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getSecondCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getLottoNumberFromEvent(editEvent).setNumber2(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getThirdCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getLottoNumberFromEvent(editEvent).setNumber3(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getFourthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getLottoNumberFromEvent(editEvent).setNumber4(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getFifthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getLottoNumberFromEvent(editEvent).setNumber5(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getSixthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getLottoNumberFromEvent(editEvent).setNumber6(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getLuckyNumCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLuckyNumber(newValue))
					getLottoNumberFromEvent(editEvent).setLuckyNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
	}
	//check if input is a number
	private boolean isNumber(String number) {
		boolean valid;
		try {
			Integer.parseInt(number);
			valid = true;
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;
	}
	//check if input is a real lotto number
	private boolean isLottoNumber(String number) {
		if(Integer.parseInt(number) <= 42 && Integer.parseInt(number) >= 1)
			return true;
		else
			return false;
	}
	//check if input is a lucky lotto number
	private boolean isLuckyNumber(String number) {
		if(Integer.parseInt(number) <= 6 && Integer.parseInt(number) >= 1)
			return true;
		else
			return false;
	}
	
	private boolean numberIsFree(String number, CellEditEvent<LottoNumber, String> editEvent) {
		boolean free = true;
		int newNumber = Integer.parseInt(number);
		LottoNumber ln = getLottoNumberFromEvent(editEvent);
		
		if(ln.getInt() == newNumber 
				|| ln.getInt2() == newNumber 
				|| ln.getInt3() == newNumber 
				|| ln.getInt4() == newNumber 
				|| ln.getInt5() == newNumber 
				|| ln.getInt6() == newNumber)
			free = false;
		return free;
	}
	

	private LottoNumber getLottoNumberFromEvent(CellEditEvent<LottoNumber, String> editEvent) {
		TableView<LottoNumber> tv = editEvent.getTableView();
		int rowNumber = editEvent.getTablePosition().getRow();
		return tv.getItems().get(rowNumber);
	}
}