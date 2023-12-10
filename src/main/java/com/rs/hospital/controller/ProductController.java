package com.rs.hospital.controller;

import com.rs.hospital.dto.ProductDTO;
import com.rs.hospital.service.ProductServiceImpl;
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
public class ProductController{
    @Autowired
    private ProductServiceImpl productImpl;

    @PostMapping(value="/product",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {

        ProductDTO productDTO = productImpl.save(product);
        return ResponseEntity.ok().body(productDTO);
    }

    @PutMapping(value="/product/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductDTO> updaTeproduct(@RequestBody ProductDTO product
            ,  @PathVariable("id") long productId) throws Exception {

        ProductDTO empDTO = productImpl.update(product, productId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/product/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable long id) throws Exception{
        return productImpl.delete(id);
    }

    @GetMapping(value="/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductDTO> findById(@PathVariable long id) throws Exception {

        ProductDTO productDTO = productImpl.getById(id);
        return ResponseEntity.ok().body(productDTO);
    }

    @GetMapping(value="/product")
    public ResponseEntity<List<ProductDTO>> listAll()
    {
        List<ProductDTO> productDTO = productImpl.getAll();
        return ResponseEntity.ok().body(productDTO);
    }

    @PostMapping(value="/product/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody ProductDTO productDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(productImpl.isExists(productDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }


    @GetMapping(value="/product/category/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<ProductDTO>> getAllProductByCategoryId(@PathVariable long id) {

        List<ProductDTO> productDTO = productImpl.getAllProductByCategoryId(id);
        return ResponseEntity.ok().body(productDTO);
    }


}


