package com.rs.hospital.service;

import com.rs.hospital.dto.DepartmentDTO;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

	public DepartmentDTO save(DepartmentDTO department);
    public DepartmentDTO update(DepartmentDTO department, long deptid) throws Exception;
	public DepartmentDTO getById(long deptid) throws Exception;
	public List<DepartmentDTO> getAll();
	public Map<String, Boolean> delete(long deptid) throws Exception;

}
