package lesson_13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Angestellter {

	String vname, nname;
	int AHVNr;
	
	public Angestellter(int AHVNr, String vname, String nname) {
		this.AHVNr = AHVNr;
		this.nname = nname;
		this.vname = vname;
	}

	@Override
	public String toString() {
		return "Angestellter [vname=" + vname + ", nname=" + nname + ", AHVNr=" + AHVNr + "]";
	}

	public static void saveAngestellter(Connection con, Angestellter a) {
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(
					"INSERT INTO Angestellter (AHVNr, vname, nname) VALUES (?,?,?) ON DUPLICATE KEY UPDATE AHVNr=?");
			stmt.setString(1, String.valueOf(a.AHVNr));
			stmt.setString(2, a.vname);
			stmt.setString(3, a.nname);
			stmt.setString(4, String.valueOf(a.AHVNr));
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static Angestellter getAngestellterById(Connection con, int id) {
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
}
