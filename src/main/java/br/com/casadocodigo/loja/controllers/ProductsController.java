package br.com.casadocodigo.loja.controllers;


import javax.servlet.http.Part;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.conf.FileSaver;
import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.validation.ProductValidator;

@Controller
@RequestMapping("/produtos")
@Transactional
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private FileSaver fileSaver;
	/*
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
	}
 */
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(MultipartFile summary,
							@Valid Product product,							
							BindingResult bindingResult,
							RedirectAttributes redirectAttributes) {
		
		System.out.println(summary.getName());
		
		if(bindingResult.hasErrors()) {
			return form(product);
		}
		
		
		String webPath = fileSaver.write("uploader-images",summary);
		product.setSummaryPath(webPath);
		
		
		productDAO.save(product);

		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView mv = new ModelAndView("products/form");
		mv.addObject("types", BookType.values());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("products", productDAO.list());
		return "products/list";
	}
	
	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("products/show");
		
		Product product = productDAO.find(id);
		modelAndView.addObject("product",product);
		return modelAndView;
	}
}
