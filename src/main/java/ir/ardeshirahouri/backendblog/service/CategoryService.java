package ir.ardeshirahouri.backendblog.service;


import ir.ardeshirahouri.backendblog.dto.ServiceResponse;
import ir.ardeshirahouri.backendblog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    ServiceResponse saveAndUpdateCategory(Category category);
    ServiceResponse deleteCategory(Integer categoryid);
}
