package entity;

public class CTHDDV {
	DICHVU dichVu;
	HOADONDICHVU hddv;
	NHANVIEN nhanVien;
	public DICHVU getDichVu() {
		return dichVu;
	}
	public void setDichVu(DICHVU dichVu) {
		this.dichVu = dichVu;
	}
	public HOADONDICHVU getHddv() {
		return hddv;
	}
	public void setHddv(HOADONDICHVU hddv) {
		this.hddv = hddv;
	}
	public NHANVIEN getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NHANVIEN nhanVien) {
		this.nhanVien = nhanVien;
	}
	public CTHDDV(DICHVU dichVu, HOADONDICHVU hddv, NHANVIEN nhanVien) {
		super();
		this.dichVu = dichVu;
		this.hddv = hddv;
		this.nhanVien = nhanVien;
	}
	public CTHDDV() {
		super();
		// TODO Auto-generated constructor stub
	}
}
