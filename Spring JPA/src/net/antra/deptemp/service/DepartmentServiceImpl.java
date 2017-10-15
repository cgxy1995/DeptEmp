package net.antra.deptemp.service;

import java.util.List;

import javax.transaction.Transactional;

import net.antra.deotemp.utility.Constants;
import net.antra.deptemp.dao.DepartmentDAO;
import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.DeptEmpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO deptDAO;

	@Override
	@Transactional
	public void saveDept(Department dept) {
		if(dept.getStatus() == null){
			DeptEmpCode status = new DeptEmpCode();
			status.setId(Constants.DEFAUL_DEPT_STATUS_ID);
			dept.setStatus(status);
			//deptDAO.save2(status);
		}
		deptDAO.save(dept);
	}

	@Override
	@Transactional
	public List<Department> loadDeptDetails() {
		return deptDAO.findAllDepartments();
	}

	@Override
	public List<Department> loadDeptBasicInfo() {
		return deptDAO.findBasicDeptInfo();
	}

}
