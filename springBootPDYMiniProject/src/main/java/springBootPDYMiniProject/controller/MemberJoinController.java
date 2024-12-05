package springBootPDYMiniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootPDYMiniProject.command.UserCommand;
import springBootPDYMiniProject.service.memberJoin.MemberJoinService;

@Controller
@RequestMapping("register")
public class MemberJoinController {

	@Autowired
	MemberJoinService memberJoinService;

	@ModelAttribute
	public UserCommand userCommand() {
		return new UserCommand();
	}

	@RequestMapping("membershipAgree")
	public String membershipAgree() {
		return "thymeleaf/memberJoin/membershipAgree";
	}

	@GetMapping("membershipInfo")
	public String membershipInfo() {
		return "thymeleaf/memberJoin/membershipInfo";
	}

	@PostMapping("membershipInfo")
	public String membershipInfo1(@Validated UserCommand userCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/memberJoin/membershipInfo";
		}
		memberJoinService.execute(userCommand);
		return "thymeleaf/memberJoin/membershipFinished";
	}
	
	@GetMapping("membershipFinished")
	public String membershipFinished() {
	    return "thymeleaf/memberJoin/membershipFinished"; // 뷰 이름 반환
	}

}
