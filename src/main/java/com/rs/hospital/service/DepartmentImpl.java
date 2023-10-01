package com.rs.hospital.service;

import com.rs.hospital.dto.DepartmentDTO;
import com.rs.hospital.model.Department;
import com.rs.hospital.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepartmentImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository dRepo;
	
	private Department convertDTOtoModel(DepartmentDTO departmentDTO) {
		
		Department dept = new Department();
		
		dept.setDeptId(departmentDTO.getDeptId());
		dept.setDeptName(departmentDTO.getDeptName());
		
		return dept;
	}
	
	/*
	 * Convert Model To DTO
	 */
	private DepartmentDTO convertModelToDTO(Department dept) {
		return new DepartmentDTO(dept);
	}
	
	@Override
	public DepartmentDTO save(DepartmentDTO department) {
		Department dept = convertDTOtoModel(department);
		dRepo.save(dept);
		return department;
	}

	@Override
	public DepartmentDTO update(DepartmentDTO department, long deptid) throws Exception{

		DepartmentDTO copyDepartment= getById(deptid);
		
		copyDepartment.setDeptName(department.getDeptName());
		
		Department dept = convertDTOtoModel(copyDepartment);
		dRepo.save(dept);
		return copyDepartment;

	}

	@Override
	public DepartmentDTO getById(long deptid) throws Exception {
		return convertModelToDTO(dRepo.getById(deptid));
	}

	@Override
	public List<DepartmentDTO> getAll() {
		List<Department> deptList = dRepo.findAll();
		List<DepartmentDTO> deptDTOList = new ArrayList<>();
		
		for(Department dept : deptList) {
			deptDTOList.add(convertModelToDTO(dept));
		}
		return deptDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long deptid) throws Exception {
		DepartmentDTO dept = getById(deptid);
		dRepo.delete(convertDTOtoModel(dept));
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}

}
