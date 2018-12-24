package ir.ardeshirahouri.backendblog.service.imp;

import ir.ardeshirahouri.backendblog.dto.ServiceResponse;
import ir.ardeshirahouri.backendblog.model.Category;
import ir.ardeshirahouri.backendblog.repository.CategoryRepository;
import ir.ardeshirahouri.backendblog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public ServiceResponse saveAndUpdateCategory(Category category) {
        Category savedCategory= categoryRepository.saveAndFlush(category);
        if (savedCategory.getCategoryId()!=null)
            return new ServiceResponse("saved or updated category",savedCategory);
        else
            return new ServiceResponse("failed operation",category);
    }

    @Override
    public ServiceResponse deleteCategory(Integer categoryid) {
        categoryRepository.deleteById(categoryid);
        return new ServiceResponse("category deleted",new Category());
    }

}
