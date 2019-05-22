package lesson_13;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/coursedb"
				+ "?useLegacyDatetimeCode=false&serverTimezone=UTC","root","Waswosch?12!")){
			
			//überprüft, ob die Tabelle schon vonhanden ist
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(null, null, "Hartmann", new String []  {"TABLE"});
			
			if(!rs.next()) {
				Statement stmt = con.createStatement();
				stmt.execute("create table Hartmann (AHVNr integer primary key)");
			} else {
				System.out.println("Hartmann schon vohanden");
			}
			
			//Zugriff über data access Klasse
			AngestellterRepository repo = new AngestellterRepository(con);
			
			Angestellter a = repo.getAngestellterById(1997);
			a.setVname("Diego");
			a.setAHVNr(1234);
			repo.saveAngestellter(a);
			System.out.println(a);
			ArrayList<Angestellter> temp = repo.getAll();
			temp.forEach(System.out::println);
			
			/*
			Angestellter b = new Angestellter(1993, "Dario", "Bugmann");
			Angestellter.saveAngestellter(con, b);
			Angestellter c = Angestellter.getAngestellterById(con, 1993);
			
			System.out.println(c.toString());
			//mit whitelist für zeichen arbeiten, um Anführungszeichen als eingabe zu verhindern oder...
			String userInput = "1 OR 1=1";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select salaer from angestellter where ahvnr="+userInput);

			//mit preparedStatements arbeiten, um Injections zu verhindern
			PreparedStatement stmt2 = con.prepareStatement("select salaer from angestellter where ahvnr=?");
			//mit 1 wird das erste ? ersetzt
			stmt2.setString(1, userInput);
			stmt2.executeQuery();
			
			while(rs.next()) {
				System.out.println("Wert: "+ rs.getString(1));
			}
			*/
		} catch(SQLException err) {
			System.out.println(err.getMessage());
		}
	}
}
