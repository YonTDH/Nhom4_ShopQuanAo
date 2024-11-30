package iuh.se.services;

import iuh.se.entities.TaiKhoan;
import java.util.List;
import java.util.Optional;

public interface TaiKhoanService {
    List<TaiKhoan> findAll();
    Optional<TaiKhoan> findById(String maDangNhap);
    TaiKhoan save(TaiKhoan taiKhoan);
    void deleteById(String maDangNhap);
    boolean existsById(String maDangNhap);
    TaiKhoan findByMaDangNhap(String maDangNhap);
    boolean authenticate(String maDangNhap, String matKhau);
    boolean updateMatKhau(String maDangNhap, String oldMatKhau, String newMatKhau);
}