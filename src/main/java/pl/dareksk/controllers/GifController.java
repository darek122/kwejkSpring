package pl.dareksk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.dareksk.data.GifRepository;
import pl.dareksk.models.Gif;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap){
        List<Gif> gifs=gifRepository.getAllGifs();
        modelMap.put("gif",gifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name,ModelMap modelMap){
        Gif gif=gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";
    }
}
