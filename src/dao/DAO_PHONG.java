package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.PHONG;
import entity.LOAIPHONG;

public class DAO_PHONG {	
	public ArrayList<PHONG> getAlltbPhong() {
		ArrayList<PHONG> dsnv = new ArrayList<PHONG>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from [dbo].[PHONG]");
			while (rs.next()) {
				PHONG nv = new PHONG(rs.getString(1), new LOAIPHONG(rs.getString(2)), rs.getString(3));	 		
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return dsnv;
	}
}
