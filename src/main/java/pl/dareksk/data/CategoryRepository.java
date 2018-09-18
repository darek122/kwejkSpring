package pl.dareksk.data;

import org.springframework.stereotype.Component;
import pl.dareksk.models.Category;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES= Arrays.asList(
            new Category("funny",1),
            new Category("sport",2),
            new Category("it",3)
    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }
    public Category findById(int id){
        for(Category category:ALL_CATEGORIES){
            if(category.getId()==id){
                return category;
            }
        }
        return null;
    }
    public Category findByName(String name){
        for(Category category:ALL_CATEGORIES){
            if(category.getName().equals(name)){
                return category;
            }
        }
        return null;
    }

}
