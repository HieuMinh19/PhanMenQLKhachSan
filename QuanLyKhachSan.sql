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
	MaCTDichVu int ,
	MaDichVu int,
	SoLuong int,
	MaCTDatPhong int,
	TongTienDichVu int,
	constraint  PK_CTDATPhong primary key (MaDichVu, MaCTDatPhong) 
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
/*create table Chi Tiet Dat Phong
go
INSERT INTO CTDATPHONG(MaCTDatPhong, NgayThucHien, MaKhachHang, NgayNhan, NgayTra, MaPhong, MaNhanVien) 
values (1,'1998-11-15', 1, '2019-05-05','2019-05-07', 101, 2)
INSERT INTO CTDATPHONG(MaCTDatPhong, NgayThucHien, MaKhachHang, NgayNhan, NgayTra, MaPhong, MaNhanVien) 
values (2,'1998-11-15', 2, '2019-05-06','2019-05-08', 102, 2)
INSERT INTO CTDATPHONG(MaCTDatPhong, NgayThucHien, MaKhachHang, NgayNhan, NgayTra, MaPhong, MaNhanVien) 
values (3,'1998-11-15', 3, '2019-05-08','2019-05-10', 201, 3)
INSERT INTO CTDATPHONG(MaCTDatPhong, NgayThucHien, MaKhachHang, NgayNhan, NgayTra, MaPhong, MaNhanVien) 
values (4,'1998-11-15', 4, '2019-05-08','2019-05-10', 103, 3)
INSERT INTO CTDATPHONG(MaCTDatPhong, NgayThucHien, MaKhachHang, NgayNhan, NgayTra, MaPhong, MaNhanVien) 
values (5,'1998-11-15', 5, '2019-06-11','2019-06-13', 201, 3)

go
INSERT INTO KHACHHANG(MaKhachHang, HoTen, Email, DiaChi, DienThoai, CMND) 
values (1,'Le Van Teo', 'teo@gmail.com', 'Ha Noi',123123132, 258963147)
INSERT INTO KHACHHANG(MaKhachHang, HoTen, Email, DiaChi, DienThoai, CMND) 
values (2,'Le Van Tí', 'ti@gmail.com', 'Ho Chi Minh',123253132, 258963147)
INSERT INTO KHACHHANG(MaKhachHang, HoTen, Email, DiaChi, DienThoai, CMND) 
values (3,'Le Van Kheo', 'khoe@gmail.com', 'Da Nang',123169132, 258963147)
INSERT INTO KHACHHANG(MaKhachHang, HoTen, Email, DiaChi, DienThoai, CMND) 
values (4,'Nguyen Phuc Duc', 'duc@gmail.com', 'Da Nang',123169132, 258963147)
INSERT INTO KHACHHANG(MaKhachHang, HoTen, Email, DiaChi, DienThoai, CMND) 
values (5,'Le Minh Hieu', 'hieu@gmail.com', 'Long An',253169132, 258925647)

go
INSERT INTO HOADON(NgayThuTien, SoTienThu, MaCTDatPhong, MaNhanVien) 
values ('2019-05-09',150000, 2, 2)
INSERT INTO HOADON(NgayThuTien, SoTienThu, MaCTDatPhong, MaNhanVien) 
values ('2019-05-10',200000, 2, 3)
INSERT INTO HOADON(NgayThuTien, SoTienThu, MaCTDatPhong, MaNhanVien) 
values ('2019-05-11',3000000, 3, 4)
INSERT INTO HOADON(NgayThuTien, SoTienThu, MaCTDatPhong, MaNhanVien) 
values ('2019-05-11',350000, 3, 4)
INSERT INTO HOADON(NgayThuTien, SoTienThu, MaCTDatPhong, MaNhanVien) 
values ('2019-06-12',350000, 5, 2)
*/
go
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('hieu', '1', 'Le Minh Hieu', '1998-11-15', 225786369, '2019-05-05', 1)
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('duc', '1', 'Nguyen Phuc Duc', '1998-08-09', 225764728, '2019-05-18', 2)
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('hai', '1', 'Tran Ngoc Hai', '1998-03-20', 225712598, '2019-06-11', 2)
INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) 
values ('duy', '1', 'Duy Zoan', '1998-06-07', 225896128, '2019-07-02', 2)
go
INSERT INTO CHUCVU(TenChucVu) VALUES ('Quan Ly');
INSERT INTO CHUCVU(TenChucVu) VALUES ('Le tan');
INSERT INTO CHUCVU(TenChucVu) VALUES ('Bao ve');
INSERT INTO CHUCVU(TenChucVu) VALUES ('Tap vu');
go
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (101, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (102, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (103, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (104, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (105, 1);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (201, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (202, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (203, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (204, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (205, 2);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (301, 3);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (302, 3);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (303, 3);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (304, 3);
INSERT INTO PHONG(MaPhong, MaLoaiPhong) values (305, 3);
go
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong,MoTa) VALUES ( 'Binh Dan', 300000, 'Mot giuong doi . May lanh');
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong,MoTa) VALUES ( 'Thuong Gia', 20000000,'Mot giuong doi . May lanh . View ngam bien . Tivi . Co phong lam viec');
INSERT INTO LOAIPHONG( TenLoaiPhong, GiaPhong,MoTa) VALUES ( 'Vip', 4000000, 'Mot giuong doi . May lanh . View ngam bien . Tivi');
go
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'An Sang', 30000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'An Trua', 35000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'An Toi', 35000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'Massage', 600000);
INSERT INTO DICHVU( TenDichVu,GiaDichVu) VALUES ( 'Du thuyen', 1000000);