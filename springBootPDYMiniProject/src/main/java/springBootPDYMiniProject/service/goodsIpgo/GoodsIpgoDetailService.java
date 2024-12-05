package springBootPDYMiniProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootPDYMiniProject.domain.GoodsIpgoGoodsNameDTO;
import springBootPDYMiniProject.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDetailService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;

	public GoodsIpgoGoodsNameDTO execute(String ipgoNum, String goodsNum, Model model) {
		GoodsIpgoGoodsNameDTO dto = goodsIpgoMapper.ipgoGoodsSelectOne(ipgoNum, goodsNum);
		model.addAttribute("dto", dto);
		return dto;
	}
}