package springBootPDYMiniProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import springBootPDYMiniProject.domain.GoodsDTO;

@Mapper
public interface ItemMapper {
	public int wishItem(Map<String, String> map);

	public List<GoodsDTO> wishSelectList(String memberNum);

	public Integer wishCountSelectOne(Map<String, String> map);
}