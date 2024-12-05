package springBootPDYMiniProject.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootPDYMiniProject.domain.MemberDTO;
import springBootPDYMiniProject.domain.StartEndPageDTO;
import springBootPDYMiniProject.mapper.MemberMapper;
import springBootPDYMiniProject.service.StartEndPageService;

@Service
public class MemberListService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	StartEndPageService startEndPageService;

	public void execute(String searchWord, Integer page, Model model) {
		// 한페이지에 몇개를 보여줄것인지? /// 1 , 2
		Integer limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord);
		List<MemberDTO> list = memberMapper.memberSelectList(sepDTO);
		Integer count = memberMapper.memberCount();
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}
}