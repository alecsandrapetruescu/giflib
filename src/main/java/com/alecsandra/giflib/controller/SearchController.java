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
public class SearchController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping(value = "/search", method= RequestMethod.GET)
    public String listSearch(Search name, ModelMap modelMap){
        List<Gif> allGifs = gifRepository.findAllByName(name);
        modelMap.put("gifs", allGifs);

        return "search";
    }

}
