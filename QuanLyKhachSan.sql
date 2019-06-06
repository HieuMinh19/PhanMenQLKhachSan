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
/*insert table Account*/
INSERT INTO ACCOUNT( Username, Password,Role) VALUES ('admin1', '123456', 1)
INSERT INTO ACCOUNT( Username, Password,Role) VALUES ('duc', '123456', 2)
/*insert table ChuongTrinhDanhGia*/
go
/*insert table DICHVU*/
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn sáng', 30000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'ăn toi', 100000);

/*insert table LOAIPHONG*/
go
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'VIP', 250000);
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong) VALUES ( 'Thuong', 150000);
go
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (101, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (201, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (302, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (202, 2);
go
INSERT INTO CTDANHGIA( NoiDung, NgayDanhGia) VALUES ('Che Độ Sạch sẽ',  '05/05/2019')
INSERT INTO CTDANHGIA( NoiDung, NgayDanhGia) VALUES ('Dọn Vệ Sinh',  '10/06/2019')
/*insert table CTDICHVU*/
go
/*insert table CHUCVU*/
INSERT INTO CHUCVU(TenChucVu) VALUES ('Quan Ly');
INSERT INTO CHUCVU(TenChucVu) VALUES ('Nhân Viên');
go




