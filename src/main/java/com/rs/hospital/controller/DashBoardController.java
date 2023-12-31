package com.rs.hospital.controller;

import com.rs.hospital.dto.DashBoardDTO;
import com.rs.hospital.dto.DealerDTO;
import com.rs.hospital.service.DashBoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DashBoardController {

    @Autowired
    DashBoardServiceImpl dashBoardServiceImpl;

    @GetMapping(value="/dashBoard")
    public ResponseEntity<DashBoardDTO> listAll()
    {
        DashBoardDTO dashBoardDTO = dashBoardServiceImpl.getSummaryData().get(0);
        return ResponseEntity.ok().body(dashBoardDTO);
    }
}
