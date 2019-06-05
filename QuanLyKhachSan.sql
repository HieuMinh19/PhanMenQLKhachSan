﻿go
create Database QUANLYKHACHSAN
go
use master
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
	NgayLap varchar(50),
)
go

create table CTDANHGIA
(	ID int identity(1,1) primary key ,
	NoiDung varchar(255),
	-- VoteSao float, 
	NgayDanhGia varchar(25),
)
go
create table CHUCVU(
	MaChucVu int identity(1,1) primary key,
	TenChucVu varchar(100),
)
go
/*create Nhan Vien */
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
/*create Bang Phan Cong*/
create table BANGPHANCONG
(
	MaPhanCong int identity(1,1) primary key,
	NgayPhanCong varchar(25),
	LoaiCongViec varchar(50),
	MaNhanVien int,
)
/*create table Khach hang*/
go
create table KHACHHANG(
	MaKhachHang int primary key,
	HoTen varchar(255),
	Email varchar(30),
	DiaChi varchar(50),
	DienThoai varchar(20),
	CMND varchar(20),
)
go
/*create Hoa Don*/
create table HOADON
(
	MaHoaDon int identity(1,1) primary key,
	NgayThuTien varchar(25),
	SoTienThu int,
	MaCTDatPhong int,
	MaNhanVien int,
)
go
/*create Chi Tiet Dich Vu*/
create table CTDICHVU
(
	MaCTDichVu int identity(1,1) primary key,
	MaDichVu int,
	SoLuong int,
	MaCTDatPhong int,
	TongTienDichVu int,
)
go
/*create Dich Vu*/
create table DICHVU
(
	MaDichVu int identity(1,1) primary key,
	TenDichVu varchar(50),
	GiaDichVu int,
)

go
/*create table Loai Phong*/
CREATE table LOAIPHONG
(
	MaLoaiPhong int  identity(1,1) primary key,
	TenLoaiPhong varchar(20),
	GiaPhong int,
)
GO
/*create table Phong*/
create table PHONG
(
	MaPhong int primary key,
	MaLoaiPhong int,	
)
go
/*create table Chi Tiet Dat Phong*/
create table CTDATPHONG(
	MaCTDatPhong int primary key,
	NgayThucHien Date,
	MaKhachHang int,
	NgayNhan Date,
	NgayTra Date,
	MaPhong int,
	MaNhanVien int,
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
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn sáng', 30000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);

/*insert table LOAIPHONG*/
go
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'VIP', 250000);
go
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'Thuong', 150000);

go
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (101, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (201, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (302, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (202, 2);


SELECT p.MaPhong from PHONG as p, CTDATPHONG as ctdp where (not EXISTS
(select MaPhong from CTDATPHONG as ctdp where p.MaPhong  = ctdp.MaPhong and NgayNhan between '2019-05-13' and '2019-05-15')) and (p.MaLoaiPhong = 1)

select lp.MaLoaiPhong, TenLoaiPhong, p.MaPhong, TenKH, CMND, NgayNhan, NgayTra, ThanhTien
from PHONG as p, LOAIPHONG as lp, CTDATPHONG as ctdp 
where p.MaPhong = ctdp.MaPhong and p.MaLoaiPhong = lp.MaLoaiPhong and '2018-05-04'< ctdp.NgayNhan

SELECT DISTINCT p.MaPhong from PHONG as p where (not EXISTS(select MaPhong from CTDATPHONG as ctdp where p.MaPhong  = ctdp.MaPhong
and NgayNhan between '2019-12-13' and '2019-12-16')) and (p.MaLoaiPhong = 1)




