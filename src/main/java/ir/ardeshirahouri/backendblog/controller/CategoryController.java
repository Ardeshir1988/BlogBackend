package ir.ardeshirahouri.backendblog.controller;


import ir.ardeshirahouri.backendblog.model.Category;
import ir.ardeshirahouri.backendblog.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ResourceConstants.Blog_CATEGORY)
@CrossOrigin(origins = "*")
public class CategoryController {

    private CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @RequestMapping(path = "" , method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAllCategory(),HttpStatus.OK);
    }


}
