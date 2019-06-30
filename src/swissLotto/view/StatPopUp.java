package swissLotto.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

class StatPopUp extends Stage {

	private static StatPopUp singleton;
	// ---> factory method <---
	static void showPopUp() {
		if(singleton == null)
			singleton = new StatPopUp();
		singleton.show();
	}
	//unreachable constructor
	private StatPopUp() {
		Label statistics  = new Label("6 Richtige und Glückszahl\t1 : 31'474'716\t\t0,0000032 % 	\r\n" + 
									"6 Richtige ohne Glückszahl\t1 : 6'294'943\t\t0,000016 %\r\n" + 
									"5 Richtige und Glückszahl\t1 : 145'716\t\t0,00069 %\r\n" + 
									"5 Richtige ohne Glückszahl\t1 : 29'143\t\t0,0034 % \r\n" + 
									"4 Richtige und Glückszahl\t1 : 3'330\t\t\t0,030 %\r\n" + 
									"4 Richtige ohne Glückszahl\t1 : 666\t\t\t0,15 %\r\n" + 
									"3 Richtige und Glückszahl\t1 : 220\t\t\t0,45 %\r\n" + 
									"3 Richtige ohne Glückszahl\t1 : 44\t\t\t2,27 %");
		statistics.setId("stats");
		Scene scene = new Scene(statistics, 470, 300);
		 scene.getStylesheets().add(
	                getClass().getResource("style.css").toExternalForm());
		this.setScene(scene);
		this.setResizable(false);
		this.setTitle("Statistik");
		this.getIcons().add(new Image("swissLotto/images/statistics.png"));
		this.show();
	}
}
