package iuh.se.services;

import iuh.se.entities.HoaDon;
import iuh.se.entities.KhachHang;
import iuh.se.entities.NhanVien;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HoaDonService {
	
    List<HoaDon> getAllHoaDon();
    Optional<HoaDon> getHoaDonById(String id);
    HoaDon saveHoaDon(HoaDon hoaDon);
    void deleteHoaDon(String id);
    
    List<HoaDon> findByKhachHang(KhachHang khachHang);
    
    // Tìm kiếm theo nhân viên
    List<HoaDon> findByNhanVien(NhanVien nhanVien);
    
    // Tìm kiếm theo ngày lập
    List<HoaDon> findByNgayLapHD(LocalDate ngayLapHD);
    
    // Tìm kiếm theo khoảng thời gian
    List<HoaDon> findByDateRange(LocalDate startDate, LocalDate endDate);
    
    // Tìm hóa đơn của khách hàng trong khoảng thời gian
    List<HoaDon> findByKhachHangAndDateRange(KhachHang khachHang, LocalDate startDate, LocalDate endDate);
    
    // Tìm hóa đơn của nhân viên trong khoảng thời gian
    List<HoaDon> findByNhanVienAndDateRange(NhanVien nhanVien, LocalDate startDate, LocalDate endDate);
    
    // Thống kê số lượng hóa đơn
    long countByKhachHang(KhachHang khachHang);
    long countByNhanVien(NhanVien nhanVien);
    
    // Tìm kiếm theo mã hóa đơn
    List<HoaDon> searchByMaHD(String keyword);
    
    // Tìm kiếm theo tên khách hàng
    List<HoaDon> findByTenKhachHang(String tenKH);
    
    // Tìm kiếm theo tên nhân viên
    List<HoaDon> findByTenNhanVien(String tenNV);
}