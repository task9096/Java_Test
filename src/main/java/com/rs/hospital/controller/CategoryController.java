package com.rs.hospital.controller;

import com.rs.hospital.dto.CategoryDTO;
import com.rs.hospital.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
//@PreAuthorize("hasRole('ADMIN')")
public class CategoryController{
    @Autowired
    private CategoryServiceImpl categoryImpl;

    @PostMapping(value="/category",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO category) {

        CategoryDTO categoryDTO = categoryImpl.save(category);
        return ResponseEntity.ok().body(categoryDTO);
    }

    @PutMapping(value="/category/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CategoryDTO> updaTecategory(@RequestBody CategoryDTO category
            ,  @PathVariable("id") long categoryId) throws Exception {

        CategoryDTO empDTO = categoryImpl.update(category, categoryId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/category/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable long id) throws Exception{
        return categoryImpl.delete(id);
    }

    @GetMapping(value="/category/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CategoryDTO> findById(@PathVariable long id) throws Exception {

        CategoryDTO categoryDTO = categoryImpl.getById(id);
        return ResponseEntity.ok().body(categoryDTO);
    }

    @GetMapping(value="/category")
    public ResponseEntity<List<CategoryDTO>> listAll()
    {
        List<CategoryDTO> categoryDTO = categoryImpl.getAll();
        return ResponseEntity.ok().body(categoryDTO);
    }

    @PostMapping(value="/category/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody CategoryDTO categoryDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(categoryImpl.isExists(categoryDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}


