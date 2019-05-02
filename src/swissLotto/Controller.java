package swissLotto;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn.CellEditEvent;
import swissLotto.model.Model;
import swissLotto.model.Tip;
import swissLotto.view.View;

public class Controller {
	final private Model model;
	final private View view;
	
	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
		
		view.getTipPane().getAddBtn().setOnAction(e ->{
			model.addTip();
			view.getInfoPane().addTipSpend();
		});
		
		view.getTipPane().getDeleteBtn().setOnAction(e -> {
			model.deleteTip();
			view.getInfoPane().deleteTipSpend();
		});
		
		view.getDrawPane().getEvaluate().setOnAction(e -> view.getDrawPane().displayWinner());
		
		// Event handlers for the table columns: validate user input
		view.getTipPane().getFirstCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getSecondCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber2(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getThirdCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber3(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getFourthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber4(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getFifthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber5(newValue);
				else // Erase invalid edited value by refreshing
					editEvent.getTableView().refresh();
		});
		
		view.getTipPane().getSixthCol().setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
				if (isNumber(newValue) && isLottoNumber(newValue) && numberIsFree(newValue, editEvent))
					getTipFromEvent(editEvent).setNumber6(newValue);
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
		boolean free = true;
		int newNumber = Integer.parseInt(number);
		Tip tip = getTipFromEvent(editEvent);
		
		if(tip.getInt() == newNumber 
				|| tip.getInt2() == newNumber 
				|| tip.getInt3() == newNumber 
				|| tip.getInt4() == newNumber 
				|| tip.getInt5() == newNumber 
				|| tip.getInt6() == newNumber)
			free = false;
		return free;
	}
	

	private Tip getTipFromEvent(CellEditEvent<Tip, String> editEvent) {
		TableView<Tip> tv = editEvent.getTableView();
		int rowNumber = editEvent.getTablePosition().getRow();
		return tv.getItems().get(rowNumber);
	}
}