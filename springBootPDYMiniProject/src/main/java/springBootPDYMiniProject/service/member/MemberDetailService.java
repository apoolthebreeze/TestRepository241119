package springBootPDYMiniProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootPDYMiniProject.domain.MemberDTO;
import springBootPDYMiniProject.mapper.MemberMapper;

@Service
public class MemberDetailService {
	@Autowired
	MemberMapper memberMapper;

	public void execute(Model model, String memberNum) {
		MemberDTO dto = memberMapper.memberSelectOne(memberNum);
		model.addAttribute("memberCommand", dto);

	}
}