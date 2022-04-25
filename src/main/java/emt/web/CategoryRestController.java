package emt.web;

import emt.model.Category;
import emt.model.dto.CategoryDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import emt.service.BookService;
import emt.service.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://library-emt-lab2-193025.herokuapp.com/")
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;
    private final BookService bookService;
    public CategoryRestController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping("/count")
    public List<CategoryDto> findAllByCount(){
        return bookService.findAllByCategories();
    }

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }
}