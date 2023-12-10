package com.rs.hospital.service;

import com.rs.hospital.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    public CategoryDTO save(CategoryDTO category);
    public CategoryDTO update(CategoryDTO category, long bid) throws Exception;
    public CategoryDTO getById(long bid) throws Exception;
    public List<CategoryDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(CategoryDTO categoryDto);

}
