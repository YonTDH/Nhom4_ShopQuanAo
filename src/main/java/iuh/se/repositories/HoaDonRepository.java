package iuh.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.se.entities.HoaDon;
import iuh.se.entities.KhachHang;
import iuh.se.entities.NhanVien;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    List<HoaDon> findByKhachHang(KhachHang khachHang);
    
    List<HoaDon> findByNhanVien(NhanVien nhanVien);
    
    List<HoaDon> findByNgayLapHD(LocalDate ngayLapHD);
    
    List<HoaDon> findByNgayLapHDBetween(LocalDate startDate, LocalDate endDate);
    
    List<HoaDon> findByKhachHangAndNgayLapHDBetween(
        KhachHang khachHang, 
        LocalDate startDate, 
        LocalDate endDate
    );
    
    List<HoaDon> findByNhanVienAndNgayLapHDBetween(
        NhanVien nhanVien, 
        LocalDate startDate, 
        LocalDate endDate
    );
    
    // Đếm số hóa đơn theo khách hàng
    long countByKhachHang(KhachHang khachHang);
    
    // Đếm số hóa đơn theo nhân viên
    long countByNhanVien(NhanVien nhanVien);
    
    // Custom query để tìm hóa đơn theo mã
    @Query("SELECT h FROM HoaDon h WHERE h.maHD LIKE %:keyword%")
    List<HoaDon> searchByMaHD(@Param("keyword") String keyword);
    
    // Custom query để tìm hóa đơn theo tên khách hàng
    @Query("SELECT h FROM HoaDon h JOIN h.khachHang k WHERE k.tenKH LIKE %:tenKH%")
    List<HoaDon> findByTenKhachHang(@Param("tenKH") String tenKH);
    
    // Custom query để tìm hóa đơn theo tên nhân viên
    @Query("SELECT h FROM HoaDon h JOIN h.nhanVien n WHERE n.tenNV LIKE %:tenNV%")
    List<HoaDon> findByTenNhanVien(@Param("tenNV") String tenNV);
}


