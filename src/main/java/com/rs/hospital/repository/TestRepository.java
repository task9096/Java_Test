package com.rs.hospital.repository;

import com.rs.hospital.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long> {

	@Query(value = "select * from #{#entityName} t where t.tid=?1", nativeQuery = true)
	public Test getById(long tid);
}
