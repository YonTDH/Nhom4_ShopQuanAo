package iuh.se.repositories;

import iuh.se.entities.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
    TaiKhoan findByMaDangNhap(String maDangNhap);
    boolean existsByMaDangNhap(String maDangNhap);
}