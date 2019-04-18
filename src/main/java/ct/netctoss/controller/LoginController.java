package ct.netctoss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//"loginController"
@Controller
public class LoginController {

	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("toLogin()");
		
		return "login";
	}
	@RequestMapping("/login.do")
	public String login() {
		System.out.println("toLogin()");
		
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		System.out.println("toIndex()");
		
		return "index";
	}
	
	
}
