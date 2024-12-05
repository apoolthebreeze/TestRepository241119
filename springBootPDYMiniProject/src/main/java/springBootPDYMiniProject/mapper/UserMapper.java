package springBootPDYMiniProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import springBootPDYMiniProject.domain.MemberDTO;

@Mapper
public interface UserMapper {
	public Integer userInsert(MemberDTO dto);
}