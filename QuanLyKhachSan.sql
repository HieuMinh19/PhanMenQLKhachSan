GO
drop database QUANLYKHACHSAN
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
	NgayDanhGia varchar(25),
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
	NgaySinh varchar(25),
	CMND int, 
	NgayVaoLam varchar(25),
	MaChucVu int,
)
go	
create table BANGPHANCONG
(
	MaPhanCong int identity(1,1) primary key,
	NgayPhanCong varchar(25),
	LoaiCongViec varchar(50),
	MaNhanVien int,
)

create table HOADON
(
	MaHoaDon int identity(1,1) primary key,
	NgayThuTien varchar(25),
	SoTienThu int,
	MaNhanVien int,
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
)
go
create table CTDATPHONG
(
	MaDatPhong int identity(1,1) primary key,
	TenKH varchar(100),
	CMNN varchar(20),
	MaDichVu int,
	MaPhong int, 
)
/*insert table Account*/
INSERT INTO ACCOUNT( Username, Password,Role) VALUES ('admin1', '123456', 1)
INSERT INTO ACCOUNT( Username, Password,Role) VALUES ('duc', '123456', 2)
/*insert table ChuongTrinhDanhGia*/

INSERT INTO CTDANHGIA( NoiDung, VoteSao,NgayDanhGia) VALUES ('Che Độ Sạch sẽ', 3.5, '05/05/2019')
INSERT INTO CTDANHGIA( NoiDung, VoteSao,NgayDanhGia) VALUES ('Dọn Vệ Sinh', 4.5, '10/06/2019')
/*insert table CTDICHVU*/
INSERT INTO CTDICHVU( TenCTDichVu, GiaDV, SoLuong) VALUES ( 'ăn sáng', 20000, 1);
INSERT INTO CTDICHVU( TenCTDichVu, GiaDV, SoLuong) VALUES ( 'ăn trưa', 100000, 1);
/*insert table DICHVU*/
INSERT INTO DICHVU( TenDichVu,MaCTDichVu) VALUES ( 'ăn sáng', 1);
INSERT INTO DICHVU( TenDichVu,MaCTDichVu) VALUES ( 'ăn trưa', 2);

/*insert table LOAIPHONG*/
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'VIP', 250000);
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'Thuong', 150000);

