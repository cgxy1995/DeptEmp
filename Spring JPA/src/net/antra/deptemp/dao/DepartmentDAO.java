package net.antra.deptemp.dao;

import java.util.List;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.DeptEmpCode;

public interface DepartmentDAO {

	void save(Department dept);
	void save2(DeptEmpCode code);
	List<Department> findAllDepartments();

	List<Department> findBasicDeptInfo();

}
