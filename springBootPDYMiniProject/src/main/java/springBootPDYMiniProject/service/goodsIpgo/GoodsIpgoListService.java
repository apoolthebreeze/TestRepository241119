package springBootPDYMiniProject.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootPDYMiniProject.domain.GoodsIpgoDTO;
import springBootPDYMiniProject.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoListService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;

	public void execute(Model model) {
		List<GoodsIpgoDTO> list = goodsIpgoMapper.goodsIpgoSelectList();
		model.addAttribute("list", list);
	}
}