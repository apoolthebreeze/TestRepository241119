package springBootPDYMiniProject.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootPDYMiniProject.domain.AuthInfoDTO;
import springBootPDYMiniProject.mapper.CartMapper;
import springBootPDYMiniProject.mapper.MemberMapper;

@Service
public class CartQtyDownService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;

	public void execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.memberNumSelect(auth.getUserId());
		cartMapper.cartQtyDown(goodsNum, memberNum);
	}
}