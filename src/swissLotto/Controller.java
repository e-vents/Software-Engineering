package swissLotto;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn.CellEditEvent;
import swissLotto.model.Model;
import swissLotto.model.Tip;
import swissLotto.view.View;

public class Controller {
	private final Model model;
	private final View view;
	
	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
		
		//Event-Handlers for all buttons
		view.getTipPane().getAddBtn().setOnAction(e -> {
			view.getInfoPane().updateInfoArea(e);
		});
		view.getTipPane().getDeleteBtn().setOnAction(e -> {
			view.getInfoPane().updateInfoArea(e);
		});
		view.getTipPane().getPlayBtn().setOnAction(e -> {
			view.getDrawPane().updateDrawArea();
			view.getInfoPane().updateInfoArea(e);
		});
		
		// Event handlers for the table columns: validate user input
		view.getTipPane().getFirstCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber(0, newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		view.getTipPane().getSecondCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber(1, newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		view.getTipPane().getThirdCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber(2, newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		view.getTipPane().getFourthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber(3, newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		view.getTipPane().getFifthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber(4, newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		view.getTipPane().getSixthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber(5, newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		view.getTipPane().getLuckyNumCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLuckyNumber(newValue))
					getTipFromEvent(editEvent).setLuckyNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		//make shure the last added element is allways visible
		model.getTips().addListener((ListChangeListener<Tip>) c -> {
			while (c.next()) {
				view.getTipPane().getTableView().scrollTo(c.getFrom());
			}
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
	
	//check if input isn't allready used
	private boolean numberIsFree(String number, CellEditEvent<Tip, String> editEvent) {
		
		int newNumber = Integer.parseInt(number);
		Tip tip = getTipFromEvent(editEvent);
		
		for(int i = 0; i < 6; i++) {
			if(tip.getInt(i) == newNumber)
				return false;
		}
		return true;
	}
	
	//return Tip on active Row
	private Tip getTipFromEvent(CellEditEvent<Tip, String> editEvent) {
		TableView<Tip> tv = editEvent.getTableView();
		int rowNumber = editEvent.getTablePosition().getRow();
		return tv.getItems().get(rowNumber);
	}
}