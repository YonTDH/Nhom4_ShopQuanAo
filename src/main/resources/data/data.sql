
INSERT INTO `chat_lieu` (`ma_chat_lieu`, `chat_lieu`) VALUES
	('CL01', 'Cotton'),
	('CL02', 'Denim'),
	('CL03', 'Leather');

INSERT INTO `khachhang` (`gioi_tinh`, `sdt`, `email`, `tenkh`, `makh`) VALUES
	(b'1', '0123456789', 'khach1@gmail.com', 'Nguyen A', 'KH001'),
	(b'0', '0987654321', 'khach2@gmail.com', 'Tran B', 'KH002'),
	(b'1', '0112233445', 'khach3@gmail.com', 'Le C', 'KH003');

INSERT INTO `kich_co` (`ma_kich_co`, `kich_co`) VALUES
	('L', 'Large'),
	('M', 'Medium'),
	('S', 'Small');

INSERT INTO `loai_quan_ao` (`ma_loai`, `loai`) VALUES
	('LQ01', 'Jeans'),
	('LQ02', 'T-shirt'),
	('LQ03', 'Jacket');

INSERT INTO `mau_sac` (`ma_mau_sac`, `mau_sac`) VALUES
	('MS01', 'Red'),
	('MS02', 'Blue'),
	('MS03', 'Black');

INSERT INTO `thuong_hieu` (`ma_thuong_hieu`, `thuong_hieu`) VALUES
	('TH01', 'Nike'),
	('TH02', 'Adidas'),
	('TH03', 'Puma');
INSERT INTO `khuyen_mai` (`muc_giam_gia`, `ngay_bat_dau`, `ngay_ket_thuc`, `makm`) VALUES
	(10, '2024-11-01', '2024-11-30', 'KM001'),
	(15, '2024-11-10', '2024-11-25', 'KM002'),
	(20, '2024-11-05', '2024-11-20', 'KM003');
INSERT INTO `taikhoan` (`ma_dang_nhap`, `mat_khau`, `phan_quyen`) VALUES
	('TK001', '123', 'admin'),
	('TK002', '456', 'user'),
	('TK003', '789', 'user');

INSERT INTO `nhan_vien` (`gioi_tinh`, `ngay_sinh`, `tai_khoan_id`, `dia_chi`, `email`, `manv`, `sdt`, `tennv`) VALUES
	(b'1', '1990-01-01', 'TK001', 'Hanoi', 'nv1@gmail.com', 'NV001', '0912345678', 'Nguyen D'),
	(b'0', '1988-05-10', 'TK002', 'HCM', 'nv2@gmail.com', 'NV002', '0923456789', 'Tran E'),
	(b'1', '1992-08-20', 'TK003', 'Da Nang', 'nv3@gmail.com', 'NV003', '0934567890', 'Le F');

INSERT INTO `nha_cung_cap` (`mancc`, `so_dien_thoai`, `email`, `tenncc`, `dia_chi`) VALUES
	('NCC01', '0912345678', 'ncc1@gmail.com', 'ABC Supplier', 'Hanoi'),
	('NCC02', '0923456789', 'ncc2@gmail.com', 'XYZ Supplier', 'HCM'),
	('NCC03', '0934567890', 'ncc3@gmail.com', '123 Supplier', 'Da Nang');


INSERT INTO `quan_ao` (`dongiaban`, `soluong`, `maquanao`, `machatlieu`, `makichco`, `maloai`, `mamausac`, `mancc`, `mathuonghieu`, `tenquanao`, `hinhanh`) VALUES
	(250, 100, 'QA001', 'CL01', 'S', 'LQ01', 'MS01', 'NCC01', 'TH01', 'Jeans A', 'jeans_a.jpg'),
	(150, 200, 'QA002', 'CL02', 'M', 'LQ02', 'MS02', 'NCC02', 'TH02', 'T-shirt B', 'tshirt_b.jpg'),
	(350, 50, 'QA003', 'CL03', 'L', 'LQ03', 'MS03', 'NCC03', 'TH03', 'Jacket C', 'jacket_c.jpg');
	
INSERT INTO `hoadon` (`ngay_laphd`,`tong_tien`, `makh`, `mahd`, `manv`) VALUES
	('2024-11-01',150, 'KH001', 'HD001', 'NV001'),
	('2024-11-02',250, 'KH002', 'HD002', 'NV002'),
	('2024-11-03',350, 'KH003', 'HD003', 'NV003');

INSERT INTO `employee`.`chitiethoadon` (`macthd`, `don_gia`, `so_luong`, `mahd`, `ma_quan_ao`) VALUES 
	('CTHD2', 1000, 10, 'HD001', 'QA001'),
	('CTHD3', 1000, 10, 'HD003', 'QA003'),
	('CTHD1', 1000, 10, 'HD002', 'QA002');