package com.ecom.productcatalog.service;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categorierepository;

    public CategoryService(CategoryRepository categorierepository) {
        this.categorierepository = categorierepository;
    }

    public List<Category> getAllCategories() {
        return categorierepository.findAll();
    }
}
