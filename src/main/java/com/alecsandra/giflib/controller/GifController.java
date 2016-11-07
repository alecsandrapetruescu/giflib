package com.alecsandra.giflib.controller;

import com.alecsandra.giflib.data.GifRepository;
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
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String listGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);

        modelMap.addAttribute("search", new Search());

        return "home";
    }

    @RequestMapping (value = "/gif/{name}", method = RequestMethod.GET)
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);

        modelMap.addAttribute("search", new Search());

        return "gif-details";
    }
}
