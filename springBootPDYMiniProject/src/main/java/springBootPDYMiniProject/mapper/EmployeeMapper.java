package springBootPDYMiniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootPDYMiniProject.domain.EmployeeDTO;
import springBootPDYMiniProject.domain.StartEndPageDTO;

@Mapper
public interface EmployeeMapper {
	public String autoNum();

	public Integer employeeInsert(EmployeeDTO dto);

	public List<EmployeeDTO> employeeAllSelect(StartEndPageDTO sepDTO);

	public int employeeCount(String searchWord);

	public Integer employeesDelete(@Param("employeesNum") String empsDel[]);

	public EmployeeDTO employeeOneSelect(String empNum);

	public Integer employeeUpdate(EmployeeDTO dto);

	public Integer employeeDelete(String empNum);

	public String getEmpNum(String empId);
}
