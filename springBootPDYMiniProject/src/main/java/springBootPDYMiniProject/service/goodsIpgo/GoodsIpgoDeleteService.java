package springBootPDYMiniProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootPDYMiniProject.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDeleteService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;

	public void execute(String ipgoNumNgoodsNum) {
		System.out.println("ipgoNumNgoodsNum :" + ipgoNumNgoodsNum);
		goodsIpgoMapper.ipgoGoodsNumDelete(ipgoNumNgoodsNum);
	}
}