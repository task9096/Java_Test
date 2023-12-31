package com.rs.hospital.repository;

import com.rs.hospital.dto.DashBoardDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashBoardRepository  extends CrudRepository<DashBoardDTO, Long> {

    @Query(value = "SELECT * FROM summary_table", nativeQuery = true)
    List<DashBoardDTO> getSummaryData();
}
