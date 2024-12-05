package springBootPDYMiniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootPDYMiniProject.domain.GoodsDTO;
import springBootPDYMiniProject.domain.GoodsIpgoDTO;
import springBootPDYMiniProject.domain.GoodsIpgoGoodsNameDTO;

@Mapper
public interface GoodsIpgoMapper {
	public int goodsIpgoInsert(GoodsIpgoDTO dto);

	public List<GoodsIpgoDTO> goodsIpgoSelectList();

	public GoodsIpgoGoodsNameDTO ipgoGoodsSelectOne(@Param(value = "ipgoNum") String ipgoNum,
			@Param(value = "goodsNum") String goodsNum);

	public void goodsIpgoUpdate(GoodsIpgoDTO dto);

	public void ipgoGoodsNumDelete(String ipgoNumNgoodsNum);

	public List<GoodsDTO> itemSelectList(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("searchWord") String searchWord);

	public int itemListCount(String searchWord);
}