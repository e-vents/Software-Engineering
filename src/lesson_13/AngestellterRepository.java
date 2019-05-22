package lesson_13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AngestellterRepository {
	
	private Connection con;
	
	public AngestellterRepository(Connection con) {
		this.con = con;
	}

	public void saveAngestellter(Angestellter a) {
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(
					"INSERT INTO Angestellter (AHVNr, vname, nname) VALUES (?,?,?) ON DUPLICATE KEY "
					+ "UPDATE AHVNr = ?, vname = ?, nname = ?");
			stmt.setString(1, String.valueOf(a.AHVNr));
			stmt.setString(2, a.vname);
			stmt.setString(3, a.nname);
			stmt.setString(4, String.valueOf(a.AHVNr));
			stmt.setString(5, a.vname);
			stmt.setString(6, a.nname);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public Angestellter getAngestellterById(int id) {
		Angestellter tempA = null;
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("SELECT * FROM Angestellter WHERE AHVNr=?");
			stmt.setString(1, String.valueOf(id));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				tempA = new Angestellter(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempA;
	}
	
	public ArrayList<Angestellter> getAll() {
		Statement stmt;
		ArrayList<Angestellter> tempList = new ArrayList<>();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from angestellter");
			while(rs.next()) {
				tempList.add(new Angestellter(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempList;
	}
}
