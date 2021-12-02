package group_g.christiansoeexamproject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class xController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
