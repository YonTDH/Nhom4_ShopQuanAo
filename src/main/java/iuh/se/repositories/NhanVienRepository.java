package iuh.se.repositories;

import iuh.se.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    List<NhanVien> findByTenNVContainingIgnoreCase(String tenNV);
    NhanVien findByEmail(String email);
    NhanVien findBysDT(String sDT);
    boolean existsByEmail(String email);
    boolean existsBysDT(String sDT);
}
