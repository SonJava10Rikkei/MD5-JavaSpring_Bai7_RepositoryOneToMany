package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.academy.model.Province;
import rikkei.academy.service.province.IProvinceService;

@Controller
@RequestMapping(value = {"/", "/province"})
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/provinces")
    public String showListProvince(Model model) {
        Iterable<Province> provinces = provinceService.findAll();
        model.addAttribute("listProvince", provinces);
        return "province/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        Province province = new Province();
        model.addAttribute("province", province);
        return "province/create";
    }

    @PostMapping("/create")
    public String actionCreate(@ModelAttribute("province") Province province, Model model) {
        System.out.println("province ------>" + province);
        provinceService.save(province);
        return "redirect:/provinces";
    }
}
