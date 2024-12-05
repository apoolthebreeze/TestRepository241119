package springBootPDYMiniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootPDYMiniProject.domain.MemberDTO;
import springBootPDYMiniProject.domain.StartEndPageDTO;

@Mapper
public interface MemberMapper {
	public void memberInsert(MemberDTO dto);

	public List<MemberDTO> memberSelectList(StartEndPageDTO sepDTO);

	public Integer memberCount();

	public MemberDTO memberSelectOne(String memberNum);

	public void memberUpdate(MemberDTO dto);

	public void memberDelete(String memberNum);

	public Integer memberEmailCheckUpdate(String memberEmail);

	public String memberNumSelect(String memberId);
}
