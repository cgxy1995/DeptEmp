package net.antra.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.DeptEmpCode;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Department dept) {
		em.persist(dept);
	}
	public void save2(DeptEmpCode code) {
		em.merge(code);
	}

	@Override
	public List<Department> findAllDepartments() {
		Query query = em.createQuery("select DISTINCT OBJECT(d) from Department d JOIN FETCH d.employeeList");
		return query.getResultList();
	}

	@Override
	public List<Department> findBasicDeptInfo() {
		Query query = em.createQuery("select DISTINCT OBJECT(d) from Department d ");
		return query.getResultList();
	}
	
}
