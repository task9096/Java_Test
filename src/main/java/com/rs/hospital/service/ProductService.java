package com.rs.hospital.service;

import com.rs.hospital.dto.ProductDTO;
import com.rs.hospital.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public ProductDTO save(ProductDTO product);
    public ProductDTO update(ProductDTO product, long bid) throws Exception;
    public ProductDTO getById(long bid) throws Exception;
    public List<ProductDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(ProductDTO productDto);
    public List<ProductDTO> getAllProductByCategoryId(long categoryId);

}
