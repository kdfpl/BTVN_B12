package com.btvn_b12.controller;

import com.btvn_b12.entity.CoSo;
import com.btvn_b12.service.CoSoService;
import com.btvn_b12.service.TaiKhoanNganHangService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("co-so")
public class CoSoController {

    private final CoSoService coSoService;
    private final TaiKhoanNganHangService taiKhoanNganHangService;

    public CoSoController(CoSoService coSoService, TaiKhoanNganHangService taiKhoanNganHangService) {
        this.coSoService = coSoService;
        this.taiKhoanNganHangService = taiKhoanNganHangService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listCoSo", coSoService.getAllCoSos());
        return "hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        model.addAttribute("coSo", new CoSo());
        model.addAttribute("listTK", taiKhoanNganHangService.findAll());
        return "view-add";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(Model model, @PathVariable Integer id) {
        model.addAttribute("coSo", coSoService.findById(id));
        model.addAttribute("listTK", taiKhoanNganHangService.findAll());
        return "view-update";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("cs") CoSo coSo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("coSo", coSo);
            return "view-add";
        }
        coSoService.addOrUpdate(coSo);
        return "redirect:/co-so/hien-thi";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("cs") CoSo coSo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("coSo", coSo);
            return "view-update";
        }
        coSoService.addOrUpdate(coSo);
        return "redirect:/co-so/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        coSoService.deleteById(id);
        return "redirect:/co-so/hien-thi";
    }

    @GetMapping("view-detail/{id}")
    public String viewDetail(Model model, @PathVariable Integer id) {
        model.addAttribute("coSo", coSoService.findById(id));
        model.addAttribute("listTK", taiKhoanNganHangService.findAll());
        return "view-detail";
    }

}
