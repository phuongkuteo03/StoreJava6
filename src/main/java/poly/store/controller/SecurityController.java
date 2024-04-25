package poly.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.service.AccountService;

@Controller
public class SecurityController {
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message","Vui lòng đăng nhập!");
		return "security/login";
	}
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message","Đăng nhập thành công!");
		return "security/login";
	}
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","Sai thông tin đăng nhâp!");
		return "security/login";
	}
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message","Không có quyền truy xuất!");
		return "security/login";
	}
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message","Bạn đã đăng xuất!");
		return "security/login";
	}
	
	//OAuth 2
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		accountService.loginFromOAuth2(oauth2);
		return "forward:/security/login/success";
	}
}
