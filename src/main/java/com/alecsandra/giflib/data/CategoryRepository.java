package com.alecsandra.giflib.data;

import com.alecsandra.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Technology"),
            new Category(2, "Science"),
            new Category(3, "Literature"),
            new Category(4, "Random")
    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category findById(int id){
        for(Category category : ALL_CATEGORIES){
            if(category.getId() == id) {
                return category;
            }
        }

        return null;
    }
}
