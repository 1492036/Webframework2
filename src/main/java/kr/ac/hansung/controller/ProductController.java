package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Product;
import kr.ac.hansung.service.ProductService;


//효과:class에 bean을 자동으로 관리를 하게 해줄 수 있다.
@Controller
public class ProductController {	// controller -> service -> dao
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/products") 
	public String getProducts(Model model) {
		
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "products"; // view's logical name (products.jsp) // definition name의 값과 controller의 return 값이랑 일치해야됨
	}
	
	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) {
		
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		
		return "viewProduct";
	}
}
