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
	-- VoteSao float, 
	NgayDanhGia Date,
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
/*insert table KHACHHANG*/
INSERT INTO KHACHHANG( HoTen,Email, DiaChi,DienThoai,CMND) 
VALUES ( 'Nguyen Phuc Duc', 'ducnp@gmail.com','Nha Trang - Khanh Hoa', '0335280715','225764728');
INSERT INTO KHACHHANG( HoTen,Email, DiaChi,DienThoai,CMND) 
VALUES ( 'Le Minh Hieu', 'hieulm@gmail.com','Duc Hoa - Long An', '0330715528','225756258');
go
/*insert table DICHVU*/
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn sáng', 30000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);

/*insert table LOAIPHONG*/
go
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'VIP', 250000);
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'Thuong', 150000);
go
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (1, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (2, 2);

go
INSERT INTO CTDANHGIA( NoiDung, NgayDanhGia) VALUES ('Che Do Sach Se',  '05/05/2019')
INSERT INTO CTDANHGIA( NoiDung, NgayDanhGia) VALUES ('Don Ve Sinh',  '10/06/2019')
/*insert table CTDICHVU*/
go
/*insert table CHUCVU*/
INSERT INTO CHUCVU(TenChucVu) VALUES ('Quan Ly');
INSERT INTO CHUCVU(TenChucVu) VALUES ('Le tan');
go
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('ql', '1', 'le minh hieu', '2019-06-05', 475834, '2012-05-05', 1)
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('nv', '1', 'le minh hieu', '2019-06-05', 475834, '2012-05-05', 2)
go
/*insert table CTDATPHONG*/
INSERT INTO CTDATPHONG( NgayThucHien,MaKhachHang, NgayNhan,NgayTra,MaPhong, MaNhanVien) 
VALUES ( '02/06/2019', '1','03/06/2019', '05/06/2019',1,1);
INSERT INTO CTDATPHONG( NgayThucHien,MaKhachHang, NgayNhan,NgayTra,MaPhong, MaNhanVien) 
VALUES ( '02/05/2019', '2','03/05/2019', '05/05/2019',2,2);
go
/*insert table CTDICHVU*/
INSERT INTO CTDICHVU( MaDichVu,SoLuong, MaCTDatPhong,TongTienDichVu) 
VALUES ( 1,1,1,1);
INSERT INTO CTDICHVU( MaDichVu,SoLuong, MaCTDatPhong,TongTienDichVu) 
VALUES ( 2,2,2,2);
INSERT INTO CTDICHVU( MaDichVu,SoLuong, MaCTDatPhong,TongTienDichVu) 
VALUES ( 3,3,3,3);
INSERT INTO CTDICHVU( MaDichVu,SoLuong, MaCTDatPhong,TongTienDichVu) 
VALUES ( 1,1,1,1);

