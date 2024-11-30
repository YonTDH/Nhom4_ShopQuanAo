package iuh.se.controllers;

import iuh.se.entities.ChiTietHoaDon;
import iuh.se.entities.HoaDon;
import iuh.se.entities.KhachHang;
import iuh.se.entities.NhanVien;
import iuh.se.entities.QuanAo;
import iuh.se.services.ChiTietHoaDonService;
import iuh.se.services.HoaDonService;
import iuh.se.services.KhachHangService;
import iuh.se.services.NhanVienService;
import iuh.se.services.QuanAoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private QuanAoService quanAoService;  // Inject QuanAoService
    
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;
    @GetMapping
    public String showHoaDonPage(Model model) {
        List<KhachHang> khachHangs = khachHangService.getAllKhachHang();
        List<NhanVien> nhanViens = nhanVienService.findAll();
        List<QuanAo> products = quanAoService.getAllQuanAo(); 

        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayLapHD(LocalDate.now());  

        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("nhanViens", nhanViens);
        model.addAttribute("hoaDons", hoaDonService.getAllHoaDon());
        model.addAttribute("products", products); 

        return "hoadon";
    }

    @GetMapping("/list")
    public String showHoaDonList(Model model) {
        List<HoaDon> hoaDons = hoaDonService.getAllHoaDon();
        model.addAttribute("hoaDons", hoaDons);
        return "hoadon/list"; // This should match the path to your list.html file
    }
    
    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        return "hoadon/success";  
    }


    @GetMapping("/search")
    public String searchHoaDon(@RequestParam("keyword") String keyword, Model model) {
        List<HoaDon> hoaDons = hoaDonService.searchByMaHD(keyword);

        model.addAttribute("hoaDons", hoaDons);
        model.addAttribute("keyword", keyword);
        return "hoadon";
        }
    @PostMapping("/addproduct")
    @ResponseBody  // Add this to return JSON response
    public ResponseEntity<Map<String, Object>> addProductToInvoice(
        @RequestParam("hoaDonId") String hoaDonId,
        @RequestParam("sanPhamId") String sanPhamId,
        @RequestParam("soLuong") int soLuong) {
        
        try {
            // Lấy hóa đơn và sản phẩm từ database
            HoaDon hoaDon = hoaDonService.getHoaDonById(hoaDonId);
            QuanAo quanAo = quanAoService.getQuanAoId(sanPhamId);
            
            Map<String, Object> response = new HashMap<>();
            response.put("maQuanAo", quanAo.getMaQuanAo());
            response.put("tenQuanAo", quanAo.getTenQuanAo());
            response.put("soLuong", soLuong);
            response.put("donGia", quanAo.getDonGiaBan());
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveHoaDon(@RequestBody Map<String, Object> payload) {
        try {
            // Lấy thông tin từ payload
            String maKH = (String) payload.get("maKH");
            String maNV = (String) payload.get("maNV");
            List<Map<String, Object>> products = (List<Map<String, Object>>) payload.get("products");

            // Lấy KhachHang và NhanVien từ database
            Optional<NhanVien> nhanVienOpt = nhanVienService.findById(maNV);
            Optional<KhachHang> khachHangOpt = khachHangService.getKhachHangById(maKH);

            // Kiểm tra nếu KhachHang và NhanVien không tồn tại
            if (!nhanVienOpt.isPresent()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Nhân viên không tồn tại"));
            }
            if (!khachHangOpt.isPresent()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Khách hàng không tồn tại"));
            }

            // Tạo đối tượng HoaDon mới
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHD(UUID.randomUUID().toString());
            hoaDon.setNgayLapHD(LocalDate.now());
            hoaDon.setKhachHang(khachHangOpt.get());
            hoaDon.setNhanVien(nhanVienOpt.get());

            // Lưu HoaDon vào cơ sở dữ liệu
            hoaDon = hoaDonService.saveHoaDon(hoaDon); // Ensure HoaDon is persisted first

            // Tính toán tổng tiền (tongTien)
            double tongTien = 0;  // Thay đổi kiểu từ int sang double
            for (Map<String, Object> product : products) {
                QuanAo quanAo = quanAoService.getQuanAoId((String) product.get("maQuanAo"));
                if (quanAo == null) {
                    return ResponseEntity.badRequest().body(Map.of("error", "Sản phẩm không tồn tại: " + product.get("maQuanAo")));
                }

                // Kiểm tra kiểu dữ liệu cho 'soLuong'
                Object soLuongObj = product.get("soLuong");
                if (!(soLuongObj instanceof Integer)) {
                    return ResponseEntity.badRequest().body(Map.of("error", "Số lượng sản phẩm phải là kiểu Integer"));
                }
                Integer soLuong = (Integer) soLuongObj;

                // Ensure donGia is correctly retrieved from the Map
                Object donGiaObj = product.get("donGia");
                Double donGia = (donGiaObj instanceof Number) ? ((Number) donGiaObj).doubleValue() : 0.0;

                if (donGia < 0) {
                    return ResponseEntity.badRequest().body(Map.of("error", "Đơn giá không hợp lệ"));
                }

                double thanhTien = soLuong * donGia;  // Tính thành tiền là double
                tongTien += thanhTien;

                // Tạo ChiTietHoaDon cho sản phẩm
                ChiTietHoaDon chiTiet = new ChiTietHoaDon();
                chiTiet.setHoaDon(hoaDon); // Set the persisted HoaDon
                chiTiet.setQuanAo(quanAo);
                chiTiet.setSoLuong(soLuong);
                chiTiet.setDonGia(donGia);
                chiTiet.setMaCTHD(UUID.randomUUID().toString()); // Tạo UUID cho maCTHD

                chiTietHoaDonService.saveChiTietHoaDon(chiTiet); // Persist the ChiTietHoaDon

                // Cập nhật số lượng tồn kho
                quanAo.setSoLuong(quanAo.getSoLuong() - soLuong);
                quanAoService.createQuanAo(quanAo);
            }

            // Cập nhật tổng tiền cho HoaDon
            hoaDon.setTongTien(tongTien);
            hoaDonService.saveHoaDon(hoaDon);

            // Trả về phản hồi
            return ResponseEntity.ok(Map.of(
                "message", "Lưu hóa đơn thành công",
                "maHD", hoaDon.getMaHD()
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }



}
