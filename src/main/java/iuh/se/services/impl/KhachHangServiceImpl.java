package iuh.se.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iuh.se.entities.KhachHang;
import iuh.se.repositories.KhachHangRepository;
import iuh.se.services.KhachHangService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KhachHangServiceImpl implements KhachHangService {
    
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public Optional<KhachHang> getKhachHangById(String id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang saveKhachHang(KhachHang khachHang) {
        // Có thể thêm logic validation ở đây
        return khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteKhachHang(String id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public List<KhachHang> findByTenKH(String tenKH) {
        return khachHangRepository.findByTenKHContainingIgnoreCase(tenKH);
    }

    @Override
    public Optional<KhachHang> findBySDT(String sdt) {
        return khachHangRepository.findBysDT(sdt);
    }

    @Override
    public Optional<KhachHang> findByEmail(String email) {
        return khachHangRepository.findByEmail(email);
    }

    @Override
    public List<KhachHang> findByGioiTinh(Boolean gioiTinh) {
        return khachHangRepository.findByGioiTinh(gioiTinh);
    }

    @Override
    public List<KhachHang> searchByTenKHOrSDT(String keyword) {
        return khachHangRepository.searchByTenKHOrSDT(keyword);
    }

    @Override
    public boolean existsBySDT(String sdt) {
        return khachHangRepository.existsBysDT(sdt);
    }

    @Override
    public boolean existsByEmail(String email) {
        return khachHangRepository.existsByEmail(email);
    }

    @Override
    public long countByGioiTinh(Boolean gioiTinh) {
        return khachHangRepository.countByGioiTinh(gioiTinh);
    }

    @Override
    public List<KhachHang> searchKhachHang(String tenKH, String sdt, String email, Boolean gioiTinh) {
        return khachHangRepository.searchKhachHang(tenKH, sdt, email, gioiTinh);
    }
}