package com.rs.hospital.repository;

import com.rs.hospital.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
	
	@Query(value = "select * from #{#entityName} i where i.INS_NO=?1", nativeQuery = true)
	public Insurance getById(long iNo);

}
