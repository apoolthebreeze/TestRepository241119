package springBootPDYMiniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootPDYMiniProject.service.help.FindIdService;
import springBootPDYMiniProject.service.help.FindPwService;

@Controller
@RequestMapping("help")
public class HelpController {
	@Autowired
	FindIdService findIdService;
	@Autowired
	FindPwService findPwService;

	@RequestMapping(value = "findId", method = RequestMethod.GET)
	public String findId() {
		return "thymeleaf/help/findId";
	}

	@RequestMapping(value = "findId", method = RequestMethod.POST)
	public String findId(@RequestParam("userPhone") String userPhone, @RequestParam("userEmail") String userEmail,
			Model model) {
		findIdService.execute(userPhone, userEmail, model);
		return "thymeleaf/help/findIdOk";
	}

	@GetMapping("findPw")
	public String findPw() {
		return "thymeleaf/help/findPw";
	}

	@PostMapping("findPw")
	public String findPw(String userId, String userPhone, Model model) {
		findPwService.execute(userId, userPhone, model);
		return "thymeleaf/help/findPwOk";
	}
}
