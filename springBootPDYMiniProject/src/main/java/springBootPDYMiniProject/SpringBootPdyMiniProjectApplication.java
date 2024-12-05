package springBootPDYMiniProject;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import springBootPDYMiniProject.command.LoginCommand;
import springBootPDYMiniProject.service.CookiesService;
import springBootPDYMiniProject.service.EmailSendService;
import springBootPDYMiniProject.service.goods.MainGoodsListService;

@SpringBootApplication
@Controller
public class SpringBootPdyMiniProjectApplication {

	@Autowired
	CookiesService cookiesService;
	@Autowired
	EmailSendService emailSendService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPdyMiniProjectApplication.class, args);
	}

	@GetMapping("/")
	public String index(LoginCommand loginCommand
	// ,@RequestParam(value="page", required = false , defaultValue = "1") Integer
	// page
			, Model model, HttpServletRequest request) {
		// cookiesService.execute(request, model, loginCommand);
		return "thymeleaf/index";
	}

	@GetMapping("/mailling")
	public String mail() {
		return "thymeleaf/email";
	}

	@PostMapping("/mailling")
	public String mail(String fromEmail, String toEmail, String subject, String contents) {
		emailSendService.mailSend(fromEmail, toEmail, subject, contents);
		return "redirect:/";
	}


}
