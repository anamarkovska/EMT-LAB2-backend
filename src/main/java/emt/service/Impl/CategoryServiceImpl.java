package emt.service.Impl;

import emt.model.Category;
import emt.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        for(Category c: Category.values()){
            categoryList.add(c);
        }
        return categoryList;
    }
}
