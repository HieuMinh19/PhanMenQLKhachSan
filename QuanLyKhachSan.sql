go
drop database QUANLYKHACHSAN
go
create Database QUANLYKHACHSAN
go
use QUANLYKHACHSAN
GO
set dateformat ymd
go

create table CTDANHGIA
(	ID int identity(1,1) primary key ,
	NoiDung varchar(255),
	NgayDanhGia Date,
	MaPhong int,
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
	Username varchar(20),
	Password varchar(30),
	TenNhanVien varchar(100),
	NgaySinh Date,
	CMND int, 
	NgayVaoLam Date,
	MaChucVu int,
)
go	
/*create Bang Phan Cong*/
create table BANGPHANCONG
(
	MaPhanCong int identity(1,1) primary key,
	NgayPhanCong Date,
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
	NgayThuTien Date,
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
	MoTa varchar(255),
)
go
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
go
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('ql', '1', 'le minh hieu', '1998-11-15', 225786369, '2019-05-05', 1)
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('nv', '1', 'Nguyen Phuc Duc', '1998-08-09', 225764728, '2019-05-18', 2)
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('hai', '1', 'Tran Ngoc Hai', '1998-03-20', 225712598, '2019-06-11', 2)
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('duy', '1', 'Duy Zoan', '1998-06-07', 225896128, '2019-07-02', 2)
go
INSERT INTO CHUCVU(TenChucVu) VALUES ('Quan Ly');
INSERT INTO CHUCVU(TenChucVu) VALUES ('Le tan');
go
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (1, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (2, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (3, 3);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (4, 4);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (5, 5);
go
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong,MoTa) VALUES ( 'Binh Dan', 100000, 'Chi Co Quat');
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong,MoTa) VALUES ( 'Thuong Gia', 400000,'Co Quat Lanh va Nuoc Co Ga');
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong,MoTa) VALUES ( 'Vip', 5000000, 'Co Quat Lanh, Nuoc Co Ga, Tivi');
go
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'An Sang', 30000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'An Toi', 35000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'Banh Piza', 60000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'Buffer Trua', 100000);