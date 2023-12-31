package com.rs.hospital.service;

import com.rs.hospital.dto.DashBoardDTO;

import java.util.List;

public interface DashBoardService {
    public List<DashBoardDTO> getSummaryData();
}
