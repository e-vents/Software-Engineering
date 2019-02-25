package Lesson_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ColorPickerView extends Application {
	
	private ColorPicker cp;
	private GridPane gp;

	public ColorPickerView() {
		
		gp = new GridPane();
		cp = new ColorPicker();
		cp.autosize();
		
		gp.add(cp, 0, 0);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		Scene scene = new Scene(gp);
		stage.setScene(scene);
		stage.setTitle("Color Picker");
		stage.show();
	}
}
	
	
