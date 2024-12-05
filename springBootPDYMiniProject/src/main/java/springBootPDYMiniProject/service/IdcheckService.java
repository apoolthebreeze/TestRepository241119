package springBootPDYMiniProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootPDYMiniProject.mapper.LoginMapper;

@Service
public class IdcheckService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String userId) {
		return loginMapper.idCheckSelectOne(userId);
	}
}
