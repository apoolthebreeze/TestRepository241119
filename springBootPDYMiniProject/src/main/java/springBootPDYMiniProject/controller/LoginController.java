package springBootPDYMiniProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springBootPDYMiniProject.command.LoginCommand;
import springBootPDYMiniProject.service.IdcheckService;
import springBootPDYMiniProject.service.login.UserLoginService;

@Controller
public class LoginController {
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	UserLoginService userLoginService;

	// wrtn 코드
	@ModelAttribute("loginCommand")
	public LoginCommand loginCommand() {
		return new LoginCommand(); // LoginCommand 객체 초기화
	}

	@GetMapping("/login")
	public String login() {
		return "thymeleaf/login";
	}

	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		return idcheckService.execute(userId);
	}

	@PostMapping("/login")
	public String login(@Validated LoginCommand loginCommand, BindingResult result, HttpSession session
			 ,HttpServletResponse response) {
		userLoginService.execute(loginCommand, session, result, response);
		if (result.hasErrors()) {
			return "thymeleaf/login";
		}
		return "redirect:/";
	}

//	  //wrtn 코드
//	  
//	  @PostMapping("/login") public String login(@ModelAttribute("loginCommand")
//	  LoginCommand loginCommand, BindingResult result, HttpSession session,
//	  RedirectAttributes redirectAttributes) {
//	  userLoginService.execute(loginCommand, session, result, null);
//	  
//	  if (result.hasErrors()) { return "thymeleaf/login"; // 로그인 페이지로 돌아가기 }
//	  
//	  // 로그인 성공 후 메인 페이지로 리다이렉트 return "redirect:/"; // 메인 페이지로 리다이렉트 }

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		// return "redirect:/";
		return "thymeleaf/login";
	}

	@GetMapping("/item.login")
	public String item() {
		return "thymeleaf/login";
	}

	@PostMapping("/item.login")
	public void item(LoginCommand loginCommand, BindingResult result, HttpSession session,
			HttpServletResponse response) {
		userLoginService.execute(loginCommand, session, result, response);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "<script language='javascript'>";
		str += " opener.location.reload();";
		str += " window.self.close();";
		str += " </script>";
		out.print(str);
		out.close();
	}

}
