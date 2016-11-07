package com.alecsandra.giflib.controller;

import com.alecsandra.giflib.data.CategoryRepository;
import com.alecsandra.giflib.data.GifRepository;
import com.alecsandra.giflib.model.Category;
import com.alecsandra.giflib.model.Gif;
import com.alecsandra.giflib.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @RequestMapping (value = "/categories", method = RequestMethod.GET)
    public String listCategories(ModelMap modelMap){
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);

        modelMap.addAttribute("search", new Search());
        return "categories";
    }

    @RequestMapping (value = "/category/{id}", method = RequestMethod.GET)
    public String categoryDetails(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);

        modelMap.addAttribute("search", new Search());
        return "category";
    }


}
