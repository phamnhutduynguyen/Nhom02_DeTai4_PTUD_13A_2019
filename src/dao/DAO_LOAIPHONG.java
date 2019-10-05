package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.LOAIPHONG;

public class DAO_LOAIPHONG {	
	public ArrayList<LOAIPHONG> getalltbLoaiPhong() {
		ArrayList<LOAIPHONG> dsLoaiPhong = new ArrayList<LOAIPHONG>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from [dbo].[LOAIPHONG]");

			while (rs.next()) {
				LOAIPHONG p = new LOAIPHONG(rs.getString(1), rs.getInt(2), rs.getBytes(3), rs.getDouble(4));	 		
				dsLoaiPhong.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return dsLoaiPhong;
	}
}
