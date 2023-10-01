package com.rs.hospital.controller;

import com.rs.hospital.dto.PatientDTO;
import com.rs.hospital.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//= > Path -> http:localhost:8080/hms/api/patient
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class PatientController {

	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	@PostMapping(value="/patient",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patient) {
		
		PatientDTO patDTO = patientServiceImpl.save(patient);	
		return ResponseEntity.ok().body(patDTO);
	}
	
	@PutMapping(value="/patient/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patient,
								@PathVariable("id") long patId) throws Exception {
		
		PatientDTO patDTO = patientServiceImpl.update(patient, patId);
		return ResponseEntity.ok().body(patDTO);
	}
	
	@DeleteMapping(value="/patient/{id}")
	public Map<String, Boolean> deletePatient(@PathVariable long id) throws Exception
	{
		return patientServiceImpl.delete(id);
	}

	@GetMapping(value="/patient/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PatientDTO> findById(@PathVariable long id) throws Exception {
		
		PatientDTO patDTO =  patientServiceImpl.getById(id);
		return ResponseEntity.ok().body(patDTO);
	}
	
	@GetMapping(value="/patient")
	public ResponseEntity<List<PatientDTO>> listAll()
	{
		List<PatientDTO> patDTOList =  patientServiceImpl.getAll();
		return ResponseEntity.ok().body(patDTOList);
	}
	
	@PostMapping(value = "/patient/check")
	public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody PatientDTO patient){
		Map<String, Boolean> res = new HashMap<>();
		if(patientServiceImpl.existsByNumber(patient)) {
			res.put("available", Boolean.TRUE);
		}else {
			res.put("available", Boolean.FALSE);
		}
		
		return ResponseEntity.ok().body(res);
	}
	
}
