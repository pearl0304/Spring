package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.ShopService;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class ShopController {
		
	@Autowired
	private ShopService service;
	

	@GetMapping("/shop/search")
	public String search() {		
		return "/shop/search";
	}
	
	@GetMapping("/shop/list")
	public String list(Model model,int cate1, int cate2, String sort) {	
		
		
		ProductVo titles=service.selectTitles(cate1, cate2);
		List<ProductVo> products = service.selectProducts(cate1, cate2, sort);
		
		model.addAttribute("cate1",cate1);
		model.addAttribute("cate2",cate2);
		model.addAttribute("titles",titles);
		model.addAttribute("products",products);
		return "/shop/list";
	}
	
	@GetMapping("/shop/view")
	public String view(int code, Model model) {	
		
		ProductVo product =service.selectProduct(code);
		model.addAttribute(product);
		return "/shop/view";
	}
	
	@GetMapping("/shop/cart")
	public String cart(HttpSession sess, Model model) {		
		
		MemberVo member=(MemberVo)sess.getAttribute("smember");	
		if(member!=null) {//로그인을 했을경우
			String uid = member.getUid();
			
			List<CartVo> products =service.selelctCart(uid);
			model.addAttribute("products",products);
			return "/shop/cart";
			
			
		}
		else { //로그인을 안했을 경우 
			return "redirect:/member/login?result=1";
		}
	}
	
	
	
	
	
	
	
	@ResponseBody
	@PostMapping("/shop/cart")
	public String cart(CartVo vo, HttpSession sess) {	
		
		MemberVo member=(MemberVo)sess.getAttribute("smember");
		
		int result=0;
		
		if(member !=null) {
			vo.setUid(member.getUid());
			
			int count= service.selectCountCart(vo);
			
			if(count==0) {
				//장바구니에 상품 저장 
				result = service.insertCart(vo);
			}else {
				//이미 장바구니에 저장된 경우
				result=3;
			}
		}else {
			//로그인을 안했을 경우
			result =2;
		}
			
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	
	@GetMapping("/shop/order")
	public String order() {		
		return "/shop/order";
	}
	
	@GetMapping("/shop/order-complete")
	public String ordercomplete() {		
		return "/shop/order-complete";
	}
	
	
	
}