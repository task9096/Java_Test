package com.rs.hospital.controller;

import com.rs.hospital.dto.EmployeeDTO;
import com.rs.hospital.service.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//= > Path -> http:localhost:8080/hms/api/employee
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
//@PreAuthorize("hasRole('ADMIN')")
public class EmployeeController{	
	@Autowired
	private EmployeeImpl employeeImpl;
	
	@PostMapping(value="/employee",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) {
		
		EmployeeDTO empDTO = employeeImpl.save(employee);	
		return ResponseEntity.ok().body(empDTO);
	}
	
	@PutMapping(value="/employee/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee
			,  @PathVariable("id") long empId) throws Exception {
		
		EmployeeDTO empDTO = employeeImpl.update(employee, empId);
		return ResponseEntity.ok().body(empDTO);
	}
	
	@DeleteMapping(value="/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable long id) throws Exception{
		return employeeImpl.delete(id);
	}

	@GetMapping(value="/employee/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeDTO> findById(@PathVariable long id) throws Exception {
		
		EmployeeDTO empDTO = employeeImpl.getById(id);
		return ResponseEntity.ok().body(empDTO);
	}
	
	@GetMapping(value="/employee")
	public ResponseEntity<List<EmployeeDTO>> listAll()
	{
		List<EmployeeDTO> empDTO = employeeImpl.getAll();
		return ResponseEntity.ok().body(empDTO);
	}
	
	@PostMapping(value="/employee/check")
	public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody EmployeeDTO empDTO){
		Map<String, Boolean> res = new HashMap<>();
		if(employeeImpl.isExists(empDTO)) {
			res.put("available", Boolean.TRUE);
		}else {
			res.put("available", Boolean.FALSE);
		}
		
		return ResponseEntity.ok().body(res);
	}
	
}
