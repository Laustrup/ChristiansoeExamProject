package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Image;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("Body","Map");

        return "index";
    }

    @GetMapping("/post")
    public String post(Model model, HttpServletRequest request){
        model.addAttribute("Body", "Location");
        HttpSession session = request.getSession();
        List<Image> images = (List<Image>) session.getAttribute("session_images");
        model.addAttribute("images", images);

        return "index";
    }
}
