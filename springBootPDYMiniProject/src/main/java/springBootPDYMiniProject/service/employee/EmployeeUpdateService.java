package springBootPDYMiniProject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootPDYMiniProject.domain.EmployeeDTO;
import springBootPDYMiniProject.command.EmployeeCommand;
import springBootPDYMiniProject.mapper.EmployeeMapper;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;

	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
		dto.setEmpJumin(employeeCommand.getEmpJumin());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpPost(employeeCommand.getEmpPost());
		dto.setEmpHireDate(employeeCommand.getEmpHireDate());
		employeeMapper.employeeUpdate(dto);
	}
}
