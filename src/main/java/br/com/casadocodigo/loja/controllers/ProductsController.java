package br.com.casadocodigo.loja.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

@Controller
@RequestMapping("/produtos")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(Product product, RedirectAttributes redirectAttributes) {
		System.out.println("Gravando produto: "+product);
		productDAO.save(product);

		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		
		return "redirect:produtos";
	}
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("products/form");
		mv.addObject("types", BookType.values());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("products", productDAO.list());
		return "products/list";
	}
}
