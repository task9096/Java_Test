package com.rs.hospital.repository;

import com.rs.hospital.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	@Query(value = "select * from #{#entityName} d where d.DEP_ID=?1", nativeQuery = true)
	public Department getById(long deptId);

}
