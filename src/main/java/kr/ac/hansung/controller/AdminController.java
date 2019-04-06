package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.model.Product;
import kr.ac.hansung.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	@RequestMapping 
	public String adminPage() {
		return "admin";
	}

	//get을 처리하겠다.
	@RequestMapping("/productInventory")
	public String getProducts(Model model) { // controller -> model -> view

		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);

		return "productInventory";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {

		Product product = new Product();

		model.addAttribute("컴퓨터");

		model.addAttribute("product", product);

		return "addProduct";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	//자동 바인딩 후 //바인딩 결과를 알려줌.
	
	public String addProductPost(@Valid Product product, BindingResult result) { 
		
		if (result.hasErrors()) {
			System.out.println("Form data has some errors");

			List<ObjectError> errors = result.getAllErrors();
			
			//모든 에러를 가져오고
			
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage()); // product.java에 정의된 message들이 출력
			} // 모든 에러를 출력해주는 것.
			
			return "addProduct"; //그리고 다시 입력하는 페이지를 보여줌.
		}

		if (!productService.addProduct(product))
			System.out.println("Adding product cannot be done");

		return "redirect:/admin/productInventory"; 
	}

	@RequestMapping(value = "/productInventory/deleteProduct/{id}", method = RequestMethod.GET)
	//id를 넘겨줌.
	public String deleteProduct(@PathVariable int id) {

		if (!productService.deleteProduct(id)) {
			System.out.println("Deleting product cannot be done");
		}

		return "redirect:/admin/productInventory"; 
	}

	@RequestMapping(value = "/productInventory/updateProduct/{id}", method = RequestMethod.GET)
	//id를 넘겨줌, model도 자동으로 생성해서 넘겨줌.
	public String updateProduct(@PathVariable int id, Model model) { 

		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "updateProduct";
	}

	@RequestMapping(value = "/productInventory/updateProduct", method = RequestMethod.POST)
	public String updateProductPost(@Valid Product product, BindingResult result) { // spring에 의해 product 객체 자동 생성. 사용자가 입력한 것이 이 product 객체에 자동 넣어짐

		// System.out.println(product);
		
		if (result.hasErrors()) {
			System.out.println("Form data has some errors");

			List<ObjectError> errors = result.getAllErrors();
			//모든 에러를 가져오고
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage()); // product.java에 정의된 message들이 출력
			}//모든 에러를 출력해주는 것.
			
			return "updateProduct";
		}

		if (!productService.updateProduct(product))
			System.out.println("Updating product cannot be done");

		return "redirect:/admin/productInventory"; // getProducts() 메소드를 다시 부름 -> 이 메소드에서 model에 집어 넣는 역할을 하기 때문 //새로고침
													// 역할을 해줌
	}

}
