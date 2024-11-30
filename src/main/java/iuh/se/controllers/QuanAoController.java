package iuh.se.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import iuh.se.entities.QuanAo;
import iuh.se.services.QuanAoService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/quan-ao")
public class QuanAoController {

    @Autowired
    private QuanAoService quanAoService;

    @GetMapping("/")
    public String getAllQuanAo(Model model) {
        List<QuanAo> listQuanAo = quanAoService.getAllQuanAo();
        model.addAttribute("listQuanAo", listQuanAo);
        return "quanAo"; // Tên file JSP
    }

    @GetMapping("/edit/{id}")
    public String editQuanAo(@PathVariable String id, Model model) {
        QuanAo quanAo = quanAoService.getQuanAoId(id);
        model.addAttribute("quanAo", quanAo);
        return "quanAo"; // Tên file JSP
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdateQuanAo(@ModelAttribute QuanAo quanAo,
                                    @RequestParam("hinhAnhFile") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String uploadDir = "src/main/resources/static/images/";
            file.transferTo(new File(uploadDir + fileName));
            quanAo.setHinhAnh(fileName);
        }
        quanAoService.createQuanAo(quanAo);
        return "redirect:/quan-ao";
    }

    @PostMapping("/delete")
    public String deleteQuanAo(@RequestParam("maQuanAo") String maQuanAo) {
        quanAoService.deleteQuanAo(maQuanAo);
        return "redirect:/quan-ao";
    }
}
