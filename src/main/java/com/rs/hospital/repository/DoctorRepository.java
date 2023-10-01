package com.rs.hospital.repository;

import com.rs.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Query(value = "select * from #{#entityName} d where d.DOC_ID=?1", nativeQuery = true)
	public Doctor getById(long doctorId);
	
	@Query(value = "select * from #{#entityName} d where d.PHONE_NO=?1", nativeQuery = true)
	public Doctor existsDoctorByDoctorPhoneNO(long doctorPhoneNO);
}
