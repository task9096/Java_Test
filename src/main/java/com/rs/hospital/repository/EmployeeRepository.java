package com.rs.hospital.repository;

import com.rs.hospital.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

	@Query(value = "select * from #{#entityName} e where e.Emp_Id=?1", nativeQuery = true)
	public Employee getById(long empId);
	
	@Query(value = "select * from #{#entityName} e where e.Emp_Mobile=?1", nativeQuery = true)
	public Employee existsEmployeeByEmpMobileNo(long empMobileNo);

}
