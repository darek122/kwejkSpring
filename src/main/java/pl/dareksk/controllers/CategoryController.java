package pl.dareksk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dareksk.data.CategoryRepository;
import pl.dareksk.data.GifRepository;
import pl.dareksk.models.Category;
import pl.dareksk.models.Gif;

import java.util.List;

@Controller
public class CategoryController {

    CategoryRepository categoryRepository;
    GifRepository gifRepository;
    @Autowired
    public CategoryController(CategoryRepository categoryRepository, GifRepository gifRepository) {
        this.categoryRepository = categoryRepository;
        this.gifRepository = gifRepository;
    }





    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> categories= categoryRepository.getAllCategories();
        modelMap.put("categories",categories);
        return "categories";
    }
    @RequestMapping("/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap){
        modelMap.put("category",categoryRepository.findById(id));
        modelMap.put("gifs",gifRepository.getById(id));
        return "category";
    }

    @RequestMapping("/searchCategory")
    public String searchGif(@RequestParam String q, ModelMap modelMap){
        Category category = categoryRepository.findByName(q);
        if (category == null){
            String error = "brak kategori w bazie";
            modelMap.put("comment",error);
            return "home";}
        modelMap.put("category",category);
        modelMap.put("gifs",gifRepository.getById(category.getId()));
        return "category";
    }

}
