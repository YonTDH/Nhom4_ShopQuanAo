package iuh.se.services.impl;

import iuh.se.entities.NhanVien;
import iuh.se.repositories.NhanVienRepository;
import iuh.se.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public Optional<NhanVien> findById(String maNV) {
        return nhanVienRepository.findById(maNV);
    }

    @Override
    public NhanVien save(NhanVien nhanVien) {
        // Validate employee data before saving
        validateNhanVien(nhanVien);
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteById(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }

    @Override
    public List<NhanVien> searchByName(String tenNV) {
        return nhanVienRepository.findByTenNVContainingIgnoreCase(tenNV);
    }

    @Override
    public NhanVien findByEmail(String email) {
        return nhanVienRepository.findByEmail(email);
    }

    @Override
    public NhanVien findBySDT(String sDT) {
        return nhanVienRepository.findBysDT(sDT);
    }

    @Override
    public boolean isEmailExists(String email) {
        return nhanVienRepository.existsByEmail(email);
    }

    @Override
    public boolean isSDTExists(String sDT) {
        return nhanVienRepository.existsBysDT(sDT);
    }

    @Override
    @Transactional
    public void updateNhanVien(NhanVien nhanVien) {
        Optional<NhanVien> existingNhanVien = nhanVienRepository.findById(nhanVien.getMaNV());
        if (existingNhanVien.isPresent()) {
            // Validate update data
            validateNhanVien(nhanVien);
            
            NhanVien updatedNhanVien = existingNhanVien.get();
            // Update fields
            updatedNhanVien.setTenNV(nhanVien.getTenNV());
            updatedNhanVien.setsDT(nhanVien.getsDT());
            updatedNhanVien.setDiaChi(nhanVien.getDiaChi());
            updatedNhanVien.setEmail(nhanVien.getEmail());
            updatedNhanVien.setNgaySinh(nhanVien.getNgaySinh());
            updatedNhanVien.setGioiTinh(nhanVien.getGioiTinh());
            
            // Save updated employee
            nhanVienRepository.save(updatedNhanVien);
        } else {
            throw new RuntimeException("Không tìm thấy nhân viên với mã: " + nhanVien.getMaNV());
        }
    }

    // Helper method to validate employee data
    private void validateNhanVien(NhanVien nhanVien) {
        if (nhanVien.getMaNV() == null || nhanVien.getMaNV().trim().isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống");
        }
        if (nhanVien.getTenNV() == null || nhanVien.getTenNV().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên nhân viên không được để trống");
        }
        if (nhanVien.getsDT() == null || !nhanVien.getsDT().matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Số điện thoại không hợp lệ");
        }
        if (nhanVien.getEmail() == null || !nhanVien.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }
        if (nhanVien.getNgaySinh() == null) {
            throw new IllegalArgumentException("Ngày sinh không được để trống");
        }
        if (nhanVien.getGioiTinh() == null) {
            throw new IllegalArgumentException("Giới tính không được để trống");
        }
    }
}