package com.alecsandra.giflib.controller;

import com.alecsandra.giflib.data.GifRepository;
import com.alecsandra.giflib.model.Gif;
import com.alecsandra.giflib.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FavoriteController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping (value = "/favorites", method = RequestMethod.GET)
    public String listGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.findByFavorite();
        modelMap.put("gifs", allGifs);

        modelMap.addAttribute("search", new Search());

        return "favorites";
    }
}
