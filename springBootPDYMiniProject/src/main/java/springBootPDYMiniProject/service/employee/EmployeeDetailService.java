package springBootPDYMiniProject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootPDYMiniProject.domain.EmployeeDTO;
import springBootPDYMiniProject.mapper.EmployeeMapper;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeMapper employeeMapper;

	public void execute(String empNum, Model model) {
		EmployeeDTO vo = employeeMapper.employeeOneSelect(empNum);
		model.addAttribute("employeeCommand", vo);
	}
}
