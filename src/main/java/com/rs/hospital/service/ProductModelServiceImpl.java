package com.rs.hospital.service;

import com.rs.hospital.dto.ProductModelDTO;
import com.rs.hospital.model.ProductModel;
import com.rs.hospital.repository.ProductModelNativeRepository;
import com.rs.hospital.repository.ProductModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
@Transactional
public class ProductModelServiceImpl  implements ProductModelService {

    @Autowired
    private ProductModelRepository repo;

    @Autowired
    private ProductModelNativeRepository productModelNativeRepository;

    /**
     *
     * @param productModelDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert ProductModel DTO class to ProductModel Model Class
     */
    private ProductModel convertDTOtoModel(ProductModelDTO productModelDTO) {

        ProductModel productModel = new ProductModel();

        productModel.setId(productModelDTO.getId());
        productModel.setModelName(productModelDTO.getModelName());
        productModel.setModelNumber(productModelDTO.getModelNumber());
        productModel.setPrice(productModelDTO.getPrice());
        productModel.setProductId(productModelDTO.getProductId());
        productModel.setImageUrl(productModelDTO.getImageUrl());
        productModel.setStock(productModelDTO.getStock());

        return productModel;
    }

    /*
     * Convert Model To DTO
     */
    private ProductModelDTO convertModelToDTO(ProductModel productModel) {
        return new ProductModelDTO(productModel);
    }

    @Override
    public ProductModelDTO save(ProductModelDTO productModelDTO) {
        ProductModel productModel = convertDTOtoModel(productModelDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(productModel)); // return DTO
    }

    @Override
    public ProductModelDTO update(ProductModelDTO productModelDTO, long bid) throws Exception {

        ProductModelDTO copyProductModel = getById(bid);

        copyProductModel.setId(productModelDTO.getId());
        copyProductModel.setModelName(productModelDTO.getModelName());
        copyProductModel.setModelNumber(productModelDTO.getModelNumber());
        copyProductModel.setPrice(productModelDTO.getPrice());
        copyProductModel.setProductId(productModelDTO.getProductId());
        copyProductModel.setImageUrl(productModelDTO.getImageUrl());
        copyProductModel.setStock(productModelDTO.getStock());

        // step 1 
        ProductModel ProductModel = convertDTOtoModel(copyProductModel);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(ProductModel));
    }

    @Override
    public ProductModelDTO getById(long bid) throws Exception {
        ProductModel productModel = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(productModel);
    }

    @Override
    public List<ProductModelDTO> getAll() {
        //List<ProductModel> productModelList = repo.findAll();
        //List<ProductModelDTO> productModelDTOList = new ArrayList<>();
        List<ProductModelDTO> productModelDTOList = productModelNativeRepository.findAllProductModelWithProduct();

       /* for(ProductModel productModel : productModelList) {
            productModelDTOList.add(convertModelToDTO(productModel));
        }*/

        return productModelDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        ProductModel productModel = convertDTOtoModel(getById(bid));
        repo.delete(productModel);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(ProductModelDTO productModelDTO) {
        ProductModel productModel = repo.existsProductModelByModelNumber(productModelDTO.getModelNumber());
        if(productModel != null) {
            return true;
        }else {
            return false;
        }
    }

    public List<ProductModelDTO> getProductModelByProductId(long productId){

        List<ProductModel> productModelList = repo.getProductModelByProductId(productId);
        List<ProductModelDTO> productModelDTOList = new ArrayList<>();

        for(ProductModel productModel : productModelList) {
            productModelDTOList.add(convertModelToDTO(productModel));
        }

        return productModelDTOList;
    }

}
