package iuh.se.services;

import iuh.se.entities.NhanVien;
import java.util.List;
import java.util.Optional;

public interface NhanVienService {
    List<NhanVien> findAll();
    Optional<NhanVien> findById(String maNV);
    NhanVien save(NhanVien nhanVien);
    void deleteById(String maNV);
    List<NhanVien> searchByName(String tenNV);
    NhanVien findByEmail(String email);
    NhanVien findBySDT(String sDT);
    boolean isEmailExists(String email);
    boolean isSDTExists(String sDT);
    void updateNhanVien(NhanVien nhanVien);
}
