package springBootPDYMiniProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootPDYMiniProject.domain.CartDTO;
import springBootPDYMiniProject.domain.GoodsCartDTO;
import springBootPDYMiniProject.domain.GoodsDTO;

@Mapper
public interface CartMapper {
	public void cartMerge(CartDTO dto);
	
	public GoodsDTO goodsSelect(String goodsNum);
	public CartDTO cartSelect(Integer cartNum);
	public List<GoodsCartDTO> cartSelectList(
			@Param("memberNum") String memberNum, 
			@Param("nums") String [] nums);
	
	public int cartQtyDown(@Param("goodsNum") String goodsNum
            ,@Param("memberNum") String memberNum);
	public int goodsNumsDelete(Map<String, Object> condition);
}

