package springBootPDYMiniProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import springBootPDYMiniProject.domain.GoodsStockDTO;

@Mapper
public interface GoodsStockMapper {
	public GoodsStockDTO goodsStockSelectOne(String goodsNum);

	public int goodsVisitCountUpdate(String goodsNum);
}