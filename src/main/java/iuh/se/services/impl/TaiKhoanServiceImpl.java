package iuh.se.services.impl;

import iuh.se.entities.TaiKhoan;
import iuh.se.repositories.TaiKhoanRepository;
import iuh.se.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<TaiKhoan> findAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public Optional<TaiKhoan> findById(String maDangNhap) {
        return taiKhoanRepository.findById(maDangNhap);
    }

    @Override
    public TaiKhoan save(TaiKhoan taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public void deleteById(String maDangNhap) {
        taiKhoanRepository.deleteById(maDangNhap);
    }

    @Override
    public TaiKhoan findByMaDangNhap(String maDangNhap) {
        return taiKhoanRepository.findByMaDangNhap(maDangNhap);
    }

    @Override
    public boolean authenticate(String maDangNhap, String matKhau) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByMaDangNhap(maDangNhap);
        if (taiKhoan == null) {
            return false;
        }
        return matKhau.equals(taiKhoan.getMatKhau());  
    }

    @Override
    public boolean updateMatKhau(String maDangNhap, String oldMatKhau, String newMatKhau) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByMaDangNhap(maDangNhap);
        if (taiKhoan == null || !oldMatKhau.equals(taiKhoan.getMatKhau())) {
            return false;
        }
        taiKhoan.setMatKhau(newMatKhau);  // Cập nhật mật khẩu mới
        taiKhoanRepository.save(taiKhoan);
        return true;
    }

    @Override
    public boolean existsById(String maDangNhap) {
        return taiKhoanRepository.existsById(maDangNhap);
    }

    public void updatePhanQuyen(String maDangNhap, String newPhanQuyen) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByMaDangNhap(maDangNhap);
        if (taiKhoan != null) {
            taiKhoan.setPhanQuyen(newPhanQuyen);
            taiKhoanRepository.save(taiKhoan);
        } else {
            throw new RuntimeException("Không tìm thấy tài khoản với tên đăng nhập: " + maDangNhap);
        }
    }

    public TaiKhoan createNewAccount(String maDangNhap, String matKhau, String phanQuyen) {
        if (taiKhoanRepository.existsById(maDangNhap)) {
            throw new RuntimeException("Tài khoản đã tồn tại!");
        }

        TaiKhoan newAccount = new TaiKhoan();
        newAccount.setMaDangNhap(maDangNhap);
        newAccount.setMatKhau(matKhau); 
        newAccount.setPhanQuyen(phanQuyen);

        return taiKhoanRepository.save(newAccount);
    }

    private void validateTaiKhoan(TaiKhoan taiKhoan) {
        if (taiKhoan.getMaDangNhap() == null || taiKhoan.getMaDangNhap().trim().isEmpty()) {
            throw new IllegalArgumentException("Mã đăng nhập không được để trống");
        }
        if (taiKhoan.getMatKhau() == null || taiKhoan.getMatKhau().trim().isEmpty()) {
            throw new IllegalArgumentException("Mật khẩu không được để trống");
        }
        if (taiKhoan.getPhanQuyen() == null || taiKhoan.getPhanQuyen().trim().isEmpty()) {
            throw new IllegalArgumentException("Phân quyền không được để trống");
        }
    }
}
