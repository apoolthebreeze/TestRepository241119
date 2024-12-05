package springBootPDYMiniProject.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootPDYMiniProject.mapper.EmployeeMapper;
import springBootPDYMiniProject.service.StartEndPageService;
import springBootPDYMiniProject.domain.EmployeeDTO;
import springBootPDYMiniProject.domain.StartEndPageDTO;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	String searchWord;
	public void execute(String searchWord, int page, Model model) {
		int limit= 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit,  searchWord);
		List<EmployeeDTO> list = employeeMapper.employeeAllSelect(sepDTO);
		
		int count = employeeMapper.employeeCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}
}
