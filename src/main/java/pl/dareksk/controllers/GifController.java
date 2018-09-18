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
        modelMap.addAttribute("gifs",gifRepository.getAllGifs());
        return "home";

    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name,ModelMap modelMap){
        Gif gif=gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String getFavorites(ModelMap modelMap){
        List<Gif> gifs=gifRepository.getFavorites();
        modelMap.put("gifs",gifs);
        return "favorites";
    }
    @RequestMapping("/search")
    public String searchGif(@RequestParam String q, ModelMap modelMap){
        Gif gif = gifRepository.findByName(q);
        if (gif == null){
            String error = "brak obrazka w bazie";
            modelMap.put("comment",error);
            return "home";}
        modelMap.put("gif",gif);
        return "gif-details";
    }

}
