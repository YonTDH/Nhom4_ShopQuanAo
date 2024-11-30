package iuh.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.se.entities.KhachHang;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
    // Tìm kiếm theo tên khách hàng (không phân biệt hoa thường)
    List<KhachHang> findByTenKHContainingIgnoreCase(String tenKH);
    
    Optional<KhachHang> findBysDT(String sDT);
    
    Optional<KhachHang> findByEmail(String email);
    
    List<KhachHang> findByGioiTinh(Boolean gioiTinh);
    
    @Query("SELECT k FROM KhachHang k WHERE LOWER(k.tenKH) LIKE LOWER(CONCAT('%', :keyword, '%')) OR k.sDT LIKE %:keyword%")
    List<KhachHang> searchByTenKHOrSDT(@Param("keyword") String keyword);
    
    // Kiểm tra sự tồn tại của số điện thoại
    boolean existsBysDT(String sDT);
    
    // Kiểm tra sự tồn tại của email
    boolean existsByEmail(String email);
    
    // Đếm số lượng khách hàng theo giới tính
    long countByGioiTinh(Boolean gioiTinh);
    
    // Custom query để tìm khách hàng theo nhiều tiêu chí
    @Query("SELECT k FROM KhachHang k WHERE " +
           "(:tenKH IS NULL OR LOWER(k.tenKH) LIKE LOWER(CONCAT('%', :tenKH, '%'))) AND " +
           "(:sDT IS NULL OR k.sDT LIKE %:sDT%) AND " +
           "(:email IS NULL OR k.email LIKE %:email%) AND " +
           "(:gioiTinh IS NULL OR k.gioiTinh = :gioiTinh)")
    List<KhachHang> searchKhachHang(
        @Param("tenKH") String tenKH,
        @Param("sDT") String sDT,
        @Param("email") String email,
        @Param("gioiTinh") Boolean gioiTinh
    );
    
    // Tìm top khách hàng có mã gần đây nhất
    @Query("SELECT k FROM KhachHang k ORDER BY k.maKH DESC")
    List<KhachHang> findTopByOrderByMaKHDesc();
}