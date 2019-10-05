USE master  
GO  
Create database [PTUD_DHKTPM13A_NHOM2]
GO
use [PTUD_DHKTPM13A_NHOM2]
Go
Create table NHANVIEN(
	MaNV nvarchar(50) not null primary key,
	TenNV nvarchar(50),
	GioiTinh bit,
	CMND nvarchar(50),
	SDT nvarchar(50),
	ChucVu nvarchar(50),
	HinhAnh image
)
GO
Create table TAIKHOAN(
	MaNV nvarchar(50) not null primary key,
	foreign key (MaNV) references NHANVIEN(MaNV),
	TaiKhoan nvarchar(50),
	MatKhau nvarchar(50)
)
GO
Create table KHACHHANG(
	MaKH nvarchar(50) not null primary key,
	TenKH nvarchar(50),
	CMND nvarchar(50),
	SDT nvarchar(50),
	GioiTinh bit,
)
GO
create table HOADONPHONG(
	MaHDP nvarchar(50) not null primary key,	
	MaNV nvarchar(50) not null,
	foreign key (MaNV) references NHANVIEN(MaNV),
	MaKH nvarchar(50) not null,
	foreign key (MaKH) references KHACHHANG(MaKH),
	ThoiGianDat datetime,
	ThoiGianTra datetime,
	TinhTrang nvarchar(50),
)
GO
create table LOAIPHONG(
	MaLoaiPhong nvarchar(50) not null primary key,	
	SoLuongToiDa int,
	HinhAnh image,
	DonGia money
)
go
create table PHONG(
	SoPhong nvarchar(50) not null primary key,
	MaLoaiPhong nvarchar(50),	
	foreign key (MaLoaiPhong) references LOAIPHONG(MaLoaiPhong),
	TinhTrang nvarchar(50)
)
GO
create table CTHDPHONG(
	SoPhong nvarchar(50) not null,	
	foreign key (SoPhong) references PHONG(SoPhong),	
	MaHDP nvarchar(50) not null,			
	foreign key (MaHDP) references HOADONPHONG(MaHDP),
	SoLuong int
	constraint pk_SP_MaHDP primary key (SoPhong, MaHDP)
)
GO
Create table DICHVU(
	MaDV nvarchar(50) not null primary key,
	TenDV nvarchar(50),
	DonGia money
)
GO
create table HOADONDICHVU(
	MaHDDV nvarchar(50) not null primary key,
	MaNV nvarchar(50) not null,
	foreign key (MaNV) references NHANVIEN(MaNV),
	MaKH nvarchar(50) not null,
	foreign key (MaKH) references KHACHHANG(MaKH),
	ThoiGian datetime,
	TinhTrang nvarchar(50),
)
GO
create table CTHDDV(
	MaHDDV nvarchar(50) not null,	
	foreign key (MaHDDV) references HOADONDICHVU(MaHDDV),
	MaDV nvarchar(50),
	foreign key (MaDV) references DICHVU(MaDV),
	SoLuong int
	constraint pk_DV_HDDV primary key (MaHDDV, MaDV)
)
GO
insert [dbo].[NHANVIEN] values ('NVTT001', N'NGUYỄN VĂN A', 1, '654312346','087611212',N'TIẾP TÂN', null)
insert [dbo].[NHANVIEN] values ('NVTT002', N'NGUYỄN VĂN B', 0, '126547890','076544333',N'TIẾP TÂN', null)
insert [dbo].[NHANVIEN] values ('NVTT003', N'NGUYỄN VĂN C', 1, '654312345','096663321',N'TIẾP TÂN', null)
insert [dbo].[NHANVIEN] values ('NVTT004', N'NGUYỄN VĂN D', 0, '123456789','087654444',N'TIẾP TÂN', null)
insert [dbo].[NHANVIEN] values ('NVQL001', N'NGUYỄN VĂN E', 1, '567123489','065438111',N'QUẢN LÝ', null)

insert [dbo].[TAIKHOAN] values ('NVTT001', 'NVTT001','NVTT001')
insert [dbo].[TAIKHOAN] values ('NVTT002', 'NVTT002','NVTT002')
insert [dbo].[TAIKHOAN] values ('NVTT003', 'NVTT003','NVTT003')
insert [dbo].[TAIKHOAN] values ('NVTT004', 'NVTT004','NVTT004')
insert [dbo].[TAIKHOAN] values ('NVQL001', 'NVQL001','NVQL001')

insert [dbo].[LOAIPHONG] values('TYPE01', 2, null, 200000)
insert [dbo].[LOAIPHONG] values('TYPE02', 4, null, 250000)
insert [dbo].[LOAIPHONG] values('TYPEVIP', 4, null, 300000)

insert [dbo].[PHONG] values('P01001', 'TYPE01', 'FULL')
insert [dbo].[PHONG] values('P01002', 'TYPE01', 'FREE')
insert [dbo].[PHONG] values('P01003', 'TYPE01', 'FULL')
insert [dbo].[PHONG] values('P01004', 'TYPE01', 'FREE')
insert [dbo].[PHONG] values('P01005', 'TYPE01', 'FREE')
insert [dbo].[PHONG] values('P02001', 'TYPE02', 'REPAIRING')
insert [dbo].[PHONG] values('P02002', 'TYPE02', 'FREE')
insert [dbo].[PHONG] values('P02003', 'TYPE02', 'FREE')
insert [dbo].[PHONG] values('P02004', 'TYPE02', 'FREE')
insert [dbo].[PHONG] values('P02005', 'TYPE02', 'FULL')
insert [dbo].[PHONG] values('P03001', 'TYPEVIP', 'FULL')
insert [dbo].[PHONG] values('P03002', 'TYPEVIP', 'FREE')
insert [dbo].[PHONG] values('P03003', 'TYPEVIP', 'FREE')

insert [dbo].[KHACHHANG] values('KH0001', N'Nguyễn Thị A', '111456789', '0323459999',1)
insert [dbo].[KHACHHANG] values('KH0002', N'Nguyễn Thị B', '222256789', '0553456666',0)
insert [dbo].[KHACHHANG] values('KH0003', N'Nguyễn Thị C', '333356789', '0999456888',1)
insert [dbo].[KHACHHANG] values('KH0004', N'Nguyễn Thị D', '444456789', '0223411111',0)
insert [dbo].[KHACHHANG] values('KH0005', N'Nguyễn Thị E', '555456789', '0993453333',1)





