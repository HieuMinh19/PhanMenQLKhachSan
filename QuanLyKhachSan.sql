GO
create Database QUANLYKHACHSAN
GO
use QUANLYKHACHSAN
GO
set dateformat ymd
go
create table ACCOUNT
(
	ID int identity(1,1) primary key,
	Username varchar(20),
	Password varchar(30),
	Role int,
)
go
create table CTDANHGIA
(	ID int identity(1,1) primary key ,
	NoiDung varchar(255),
	VoteSao float, 
	NgayDanhGia datetime,
)
go
create table CHUCVU(
	MaChucVu int identity(1,1) primary key,
	TenChucVu varchar(100),
)
go

create table NHANVIEN
(
	MaNhanVien int identity(1,1) primary key,
	TenNhanVien varchar(100),
	NgaySinh datetime,
	CMND int, 
	NgayVaoLam datetime,
	MaChucVu int,
	
	CONSTRAINT PC_MACHUCVU_FK FOREIGN KEY (MaChucVu)
		REFERENCES CHUCVU(MaChucVu),
)
go	
create table BANGPHANCONG
(
	MaPhanCong int identity(1,1) primary key,
	NgayPhanCong datetime,
	LoaiCongViec varchar(50),
	MaNhanVien int,
	
	CONSTRAINT PC_MANVIEN_FK FOREIGN KEY (MaNhanVien)
		REFERENCES NHANVIEN(MaNhanVien),
)

create table HOADON
(
	MaHoaDon int identity(1,1) primary key,
	NgayThuTien datetime,
	SoTienThu int,
	MaNhanVien int,
	
	CONSTRAINT FK_HOADON FOREIGN KEY (MaNhanVien)
		REFERENCES NHANVIEN(MaNhanVien),
)
go
create table CTDICHVU
(
	MaCTDichVu int identity(1,1) primary key,
	TenCTDichVu varchar(50),
	GiaDV int,
	SoLuong int,
)
go
create table DICHVU
(
	MaDichVu int identity(1,1) primary key,
	TenDichVu varchar(50),
	MaCTDichVu int,
)
go
create table CTHOADON
(
	MaCTHoaDon int identity(1,1) primary key,
	MaHoaDon int,
	MaDichVu int,

	CONSTRAINT FK_CTHOADON_HD FOREIGN KEY (MaHoaDon)
		REFERENCES HOADON(MaHoaDon),
	CONSTRAINT FK_CTHOADON_dv FOREIGN KEY (MaDichVu)
		REFERENCES DICHVU(MaDichVu)	
)
go
CREATE table LOAIPHONG
(
	MaLoaiPhong int  identity(1,1) primary key,
	TenLoaiPhong varchar(20),
	GiaPhong int,
)
GO

create table TRANGTHAI
(
	MaTrangThai int  identity(1,1) primary key,
	TrenTrangThai varchar(20),
)
go
create table PHONG
(
	MaPhong int identity(1,1) primary key,
	MaLoaiPhong int,
	MaTrangThai int,

	CONSTRAINT FK_PHONG_LP FOREIGN KEY (MaLoaiPhong)
		REFERENCES LOAIPHONG(MaLoaiPhong),
	CONSTRAINT FK_PHONG_TT FOREIGN KEY (MaTrangThai)
		REFERENCES TRANGTHAI(MaTrangThai)	
)
go
create table CTDATPHONG
(
	MaDatPhong int identity(1,1) primary key,
	TenKH varchar(100),
	CMNN varchar(20),
	MaDichVu int,
	MaPhong int, 

	CONSTRAINT FK_CTDATPHONG_DV FOREIGN KEY (MaDichVu)
		REFERENCES DICHVU(MaDichVu),
	CONSTRAINT FK_CTDATPHONG_P FOREIGN KEY (MaPhong)
		REFERENCES PHONG(MaPhong)	
)


INSERT INTO ACCOUNT( Username, Password,Role) VALUES ('admin1', '123456', 1)


INSERT INTO CTDICHVU( MaCTDichVu, TenCTDichVu, GiaDV, SoLuong) VALUES (1, '?n sáng', 20000, 1);
INSERT INTO CTDICHVU( MaCTDichVu, TenCTDichVu, GiaDV, SoLuong) VALUES (2, '?n tr?a', 100000, 1);


INSERT INTO DICHVU( MaCTDichVu, TenDichVu,MaCTDichVu) VALUES (1, '?n sáng', 1);
INSERT INTO DICHVU( MaCTDichVu, TenDichVu,MaCTDichVu) VALUES (2, '?n tr?a', 2);
