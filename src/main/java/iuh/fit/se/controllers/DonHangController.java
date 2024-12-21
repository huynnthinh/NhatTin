package iuh.fit.se.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import iuh.fit.se.entities.DonHang;
import iuh.fit.se.services.CuaHangService;
import iuh.fit.se.services.DonHangService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/donhang")
public class DonHangController {
	@Autowired
	private DonHangService donHangService;
	@Autowired
	private CuaHangService cuaHangService;

	@GetMapping("")
	private String list(Model model) {
		model.addAttribute("listDonHang", donHangService.findAll());
		return "list";
	}

	@GetMapping("/donhangnew")
	public String addForm(Model model) {
		model.addAttribute("cuahang", cuaHangService.findAll());
		DonHang donHang = new DonHang();
		model.addAttribute("donhang", donHang);
		return "add";
	}

	@PostMapping("/themdonhang")
	public String add(@Valid @ModelAttribute("donhang") DonHang donHang, BindingResult bindingResult, Model model) {
		// TODO: process POST request
		if (bindingResult.hasErrors()) {
			model.addAttribute("cuahang", cuaHangService.findAll());
			return "add";
		}
		donHangService.save(donHang);
		return "redirect:/donhang";
	}

	@GetMapping("/dhdelete/{id}")
	public String delete(@PathVariable("id") int id) {
		donHangService.delete(id);
		return "redirect:/donhang";
	}

	@GetMapping("/dhupdate/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		DonHang donHang = donHangService.findByid(id);
		System.out.println("Ngày đặt hàng: " + donHang.getNgayDatHang());
		model.addAttribute("cuahang", cuaHangService.findAll());
		model.addAttribute("donhang", donHang);
		return "update";
	}

	@PostMapping("/dhupdate/{id}")
	public String update(@ModelAttribute("donhang") DonHang donHang, @PathVariable("id") int id) {
		// TODO: process POST request
		donHangService.update(id, donHang);
		return "redirect:/donhang";
	}

	@PostMapping("/search")
	public String search(@RequestParam(name="maDH") String maDH,@RequestParam(name="tenCH") String tenCH, Model model) {
		System.out.println(maDH + tenCH);
		model.addAttribute("listDonHang", donHangService.findByMaDHorTenCH("%"+maDH+"%", "%"+tenCH+"%"));
		return "list";
	}

}
