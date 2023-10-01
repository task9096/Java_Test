package com.rs.hospital.repository;

import com.rs.hospital.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author DELL
 * if we dont have a repository
 * 1 -> database connect
 * 2 -> table
 * 3 -> insert
 * 4 -> handle exception
 */
public interface BillRepository extends JpaRepository<Bill, Long> {

//	@Query(value = "select * from #{#entityName} w where w.is_delete=false", nativeQuery = true)
//	public List<Bill> getAllNotDeleted();
}
