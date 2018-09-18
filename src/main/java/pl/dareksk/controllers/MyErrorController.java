package pl.dareksk.controllers;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping("error")
    public String errorPage(ModelMap modelMap){
        String error = "Błąd na stronie";
        modelMap.put("comment",error);
        return "home";}

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
