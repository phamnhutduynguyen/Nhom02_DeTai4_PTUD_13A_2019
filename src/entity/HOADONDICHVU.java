package entity;

import java.util.Date;

public class HOADONDICHVU {
	private String maHDDV;
	private DICHVU dichVu;
	private KHACHHANG khachHang;
	private NHANVIEN nhanVien;
	private String tinhTrang;
	public String getMaHDDV() {
		return maHDDV;
	}
	public void setMaHDDV(String maHDDV) {
		this.maHDDV = maHDDV;
	}
	public DICHVU getDichVu() {
		return dichVu;
	}
	public void setDichVu(DICHVU dichVu) {
		this.dichVu = dichVu;
	}
	public KHACHHANG getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KHACHHANG khachHang) {
		this.khachHang = khachHang;
	}
	public NHANVIEN getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NHANVIEN nhanVien) {
		this.nhanVien = nhanVien;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public HOADONDICHVU(String maHDDV, DICHVU dichVu, KHACHHANG khachHang, NHANVIEN nhanVien, String tinhTrang) {
		super();
		this.maHDDV = maHDDV;
		this.dichVu = dichVu;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.tinhTrang = tinhTrang;
	}
	public HOADONDICHVU(String maHDDV) {
		super();
		this.maHDDV = maHDDV;
	}
	public HOADONDICHVU() {
		super();
		// TODO Auto-generated constructor stub
	}		
}
