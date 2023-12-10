package com.rs.hospital.controller;

import com.rs.hospital.dto.ProductModelDTO;
import com.rs.hospital.service.ProductModelServiceImpl;
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
public class ProductModelController{
    @Autowired
    private ProductModelServiceImpl productModelImpl;

    @PostMapping(value="/productModel",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductModelDTO> addProductModel(@RequestBody ProductModelDTO productModel) {

        ProductModelDTO productModelDTO = productModelImpl.save(productModel);
        return ResponseEntity.ok().body(productModelDTO);
    }

    @PutMapping(value="/productModel/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductModelDTO> updaTeproductModel(@RequestBody ProductModelDTO productModel
            ,  @PathVariable("id") long productModelId) throws Exception {

        ProductModelDTO empDTO = productModelImpl.update(productModel, productModelId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/productModel/{id}")
    public Map<String, Boolean> deleteProductModel(@PathVariable long id) throws Exception{
        return productModelImpl.delete(id);
    }

    @GetMapping(value="/productModel/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductModelDTO> findById(@PathVariable long id) throws Exception {

        ProductModelDTO productModelDTO = productModelImpl.getById(id);
        return ResponseEntity.ok().body(productModelDTO);
    }

    @GetMapping(value="/productModel")
    public ResponseEntity<List<ProductModelDTO>> listAll()
    {
        List<ProductModelDTO> productModelDTO = productModelImpl.getAll();
        return ResponseEntity.ok().body(productModelDTO);
    }

    @PostMapping(value="/productModel/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody ProductModelDTO productModelDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(productModelImpl.isExists(productModelDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }


    @GetMapping(value="/productModel/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<ProductModelDTO>> getProductModelByProductId(@PathVariable long id) {

        List<ProductModelDTO> productModelDTO = productModelImpl.getProductModelByProductId(id);
        return ResponseEntity.ok().body(productModelDTO);
    }

}


