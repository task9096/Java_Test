package com.rs.hospital.service;

import com.rs.hospital.dto.ProductDTO;
import com.rs.hospital.model.Product;
import com.rs.hospital.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
@Transactional
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository repo;

    /**
     *
     * @param productDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Product DTO class to Product Model Class
     */
    private Product convertDTOtoModel(ProductDTO productDTO) {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setCategoryId(productDTO.getCategoryId());
        return product;
    }

    /*
     * Convert Model To DTO
     */
    private ProductDTO convertModelToDTO(Product product) {
        return new ProductDTO(product);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = convertDTOtoModel(productDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(product)); // return DTO
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, long bid) throws Exception {

        ProductDTO copyProduct = getById(bid);
        copyProduct.setId(productDTO.getId());
        copyProduct.setProductName(productDTO.getProductName());
        copyProduct.setCategoryId(productDTO.getCategoryId());

        // step 1 
        Product Product = convertDTOtoModel(copyProduct);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(Product));
    }

    @Override
    public ProductDTO getById(long bid) throws Exception {
        Product product = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProductByCategoryId(long categoryId) {
        List<Product> productList = repo.getAllProductByCategoryId(categoryId);
        List<ProductDTO> productDTOList = new ArrayList<>();

        for(Product product : productList) {
            productDTOList.add(convertModelToDTO(product));
        }

        return productDTOList;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = repo.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for(Product product : productList) {
            productDTOList.add(convertModelToDTO(product));
        }

        return productDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Product product = convertDTOtoModel(getById(bid));
        repo.delete(product);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(ProductDTO productDTO) {
        Product product = repo.existsProductByProductName(productDTO.getProductName());
        if(product != null) {
            return true;
        }else {
            return false;
        }
    }


}
