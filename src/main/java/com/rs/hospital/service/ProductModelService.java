package com.rs.hospital.service;

import com.rs.hospital.dto.ProductModelDTO;

import java.util.List;
import java.util.Map;

public interface ProductModelService {

    public ProductModelDTO save(ProductModelDTO productModel);
    public ProductModelDTO update(ProductModelDTO productModel, long bid) throws Exception;
    public ProductModelDTO getById(long bid) throws Exception;
    public List<ProductModelDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(ProductModelDTO productModelDto);
    public List<ProductModelDTO> getProductModelByProductId(long productId);

}
