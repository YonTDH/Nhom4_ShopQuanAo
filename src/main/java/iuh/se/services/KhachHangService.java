package iuh.se.services;

import iuh.se.entities.KhachHang;
import java.util.List;
import java.util.Optional;

public interface KhachHangService {
	
    List<KhachHang> getAllKhachHang();
    Optional<KhachHang> getKhachHangById(String id);
    KhachHang saveKhachHang(KhachHang khachHang);
    void deleteKhachHang(String id);
    
    // Các phương thức tìm kiếm
    List<KhachHang> findByTenKH(String tenKH);
    Optional<KhachHang> findBySDT(String sdt);
    Optional<KhachHang> findByEmail(String email);
    List<KhachHang> findByGioiTinh(Boolean gioiTinh);
    List<KhachHang> searchByTenKHOrSDT(String keyword);
    
    // Kiểm tra tồn tại
    boolean existsBySDT(String sdt);
    boolean existsByEmail(String email);
    
    // Thống kê
    long countByGioiTinh(Boolean gioiTinh);
    
    // Tìm kiếm nâng cao
    List<KhachHang> searchKhachHang(String tenKH, String sdt, String email, Boolean gioiTinh);
}