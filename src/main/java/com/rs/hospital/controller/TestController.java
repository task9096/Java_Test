package com.rs.hospital.controller;

import com.rs.hospital.dto.TestDTO;
import com.rs.hospital.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//= > Path -> http:localhost:8080/hms/api/test
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class TestController {

	@Autowired
	private TestServiceImpl testImpl;

	@PostMapping(value = "/test",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<TestDTO> addTest(@RequestBody TestDTO test) {

		TestDTO testDTO = testImpl.save(test);
		return ResponseEntity.ok().body(testDTO);

	}

	@PutMapping(value = "/test/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<TestDTO> updateTest(@RequestBody TestDTO test
			, @PathVariable("id") long tid) throws Exception {

		TestDTO testDTO = testImpl.update(test, tid);
		return ResponseEntity.ok().body(testDTO);
	}

	@DeleteMapping(value = "/test/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Map<String, Boolean> deleteTest(@PathVariable long id) throws Exception {
		return testImpl.delete(id);
	}

	@GetMapping(value = "/test/{id}")
	public ResponseEntity<TestDTO> findById(@PathVariable long id) throws Exception {

		TestDTO testDTO = testImpl.getById(id);
		return ResponseEntity.ok().body(testDTO);
	}

	@GetMapping(value = "/test")
	public ResponseEntity<List<TestDTO>> listAll() {
		List<TestDTO> testDTOList = testImpl.getAll();
		return ResponseEntity.ok().body(testDTOList);
	}
}
