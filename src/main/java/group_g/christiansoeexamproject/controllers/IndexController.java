package group_g.christiansoeexamproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("Body","Map");

        return "index";
    }

    @GetMapping("/post")
    public String post(Model model){
        model.addAttribute("Body", "Location");

        return "index";
    }
}
