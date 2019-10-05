package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConnectDB.ConnectDB;
import entity.HOADONPHONG;
import entity.KHACHHANG;
import entity.NHANVIEN;
import entity.PHONG;

public class DAO_HDPHONG {
	public ArrayList<HOADONPHONG> getalltbHDP() {
		ArrayList<HOADONPHONG> dsP = new ArrayList<HOADONPHONG>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from HOADONPHONG");

			while (rs.next()) {
				HOADONPHONG nv = new HOADONPHONG(new PHONG(rs.getString(1)), new KHACHHANG(rs.getString(2)), new NHANVIEN(rs.getString(3)), rs.getDate(4), rs.getDate(5), rs.getString(6));	 		
				dsP.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return dsP;
	}
	public void DatPhong(String maHD, String nhanVien, String khachHang, String ngayDat, String ngayTra, String tinhTrang) {
		Connection con = ConnectDB.getInstance().getConnection();
		String query = "insert into [dbo].[HOADONPHONG](MaHDP,MaNV,MaKH,ThoiGianDat,ThoiGianTra,TinhTrang) values(?,?,?,?,?,?)";		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, maHD);
			ps.setString(2, nhanVien);
			ps.setString(3, khachHang);
			ps.setString(4, ngayDat);
			ps.setString(5, ngayTra);
			ps.setString(6, tinhTrang);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block		
			JOptionPane.showMessageDialog(null, "Lỗi Thêm");
		}		
	}
}
