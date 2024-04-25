package poly.store.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.store.entity.Product;
import poly.store.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid, @RequestParam("p") Optional<Integer> p) {
		if (cid.isPresent()) {
			Pageable pageable = PageRequest.of(p.orElse(0), 6); // số lượng sản phẩm hiển thị (5)
			Page<Product> list = productService.findByCategory(cid.get(), pageable);
			int next = list.getNumber() + 1;
			int prev = list.getNumber() - 1;
			if (list.getNumber() >= list.getTotalPages() - 1) {
				next = 0;
			} else if (list.getNumber() <= 0) {
				prev = list.getTotalPages() - 1;
			}
			model.addAttribute("prev_pager", prev);
			model.addAttribute("next_pager", next);
			model.addAttribute("items", list);
		} else {
			Pageable pageable = PageRequest.of(p.orElse(0), 6); // số lượng sản phẩm hiển thị (5)
			Page<Product> list = productService.findAll(pageable);
			int next = list.getNumber() + 1;
			int prev = list.getNumber() - 1;
			if (list.getNumber() >= list.getTotalPages() - 1) {
				next = 0;
			} else if (list.getNumber() <= 0) {
				prev = list.getTotalPages() - 1;
			}
			model.addAttribute("prev_pager", prev);
			model.addAttribute("next_pager", next);
			model.addAttribute("items", list);
		}
		return "product/list";
	}

	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.getOne(id);
		model.addAttribute("item", item);
		return "product/detail";
	}
}
