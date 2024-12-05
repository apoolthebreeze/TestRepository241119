package springBootPDYMiniProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootPDYMiniProject.mapper.AutoNumMapper;

@Service
public class MembersDeleteService {
	@Autowired
	AutoNumMapper autoNumMapper;

	public void execute(String memberNums[]) {
		autoNumMapper.numsDelete(memberNums, "members", "member_num");
	}
}