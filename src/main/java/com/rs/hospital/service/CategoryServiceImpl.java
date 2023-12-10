package com.rs.hospital.service;

import com.rs.hospital.dto.CategoryDTO;
import com.rs.hospital.model.Category;
import com.rs.hospital.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
@Transactional
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryRepository repo;

    /**
     *
     * @param categoryDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Category DTO class to Category Model Class
     */
    private Category convertDTOtoModel(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }

    /*
     * Convert Model To DTO
     */
    private CategoryDTO convertModelToDTO(Category category) {
        return new CategoryDTO(category);
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = convertDTOtoModel(categoryDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(category)); // return DTO
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO, long bid) throws Exception {

        CategoryDTO copyCategory = getById(bid);

        copyCategory.setId(categoryDTO.getId());
        copyCategory.setCategoryName(categoryDTO.getCategoryName());
        copyCategory.setCreatedBy(categoryDTO.getCreatedBy());
        copyCategory.setCreatedDate(categoryDTO.getCreatedDate());
        // step 1 
        Category Category = convertDTOtoModel(copyCategory);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(Category));
    }

    @Override
    public CategoryDTO getById(long bid) throws Exception {
        Category category = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categoryList = repo.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for(Category category : categoryList) {
            categoryDTOList.add(convertModelToDTO(category));
        }

        return categoryDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Category category = convertDTOtoModel(getById(bid));
        repo.delete(category);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(CategoryDTO categoryDTO) {
        Category category = repo.existsCategoryByCategoryName(categoryDTO.getCategoryName());
        if(category != null) {
            return true;
        }else {
            return false;
        }
    }


}
