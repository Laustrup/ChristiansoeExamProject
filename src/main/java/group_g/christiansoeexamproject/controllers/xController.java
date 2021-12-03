package group_g.christiansoeexamproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class xController {

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("Body","Map");

        return "index";
    }
}
