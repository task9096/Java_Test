package com.rs.hospital.service;

import com.rs.hospital.dto.DashBoardDTO;
import com.rs.hospital.repository.DashBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DashBoardServiceImpl implements DashBoardService{

    @Autowired
    DashBoardRepository repo;

    public List<DashBoardDTO> getSummaryData(){
        return repo.getSummaryData();
    }
}
