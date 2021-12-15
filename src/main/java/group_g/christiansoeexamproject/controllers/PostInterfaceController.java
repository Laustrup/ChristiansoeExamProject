package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Image;
import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class PostInterfaceController {

    private final Wallet wallet = Wallet.getWallet();

    @GetMapping("/location/{id}")
    public ResponseEntity<Location> giveLocation(@PathVariable int id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getAttribute("session_images");
        session.setAttribute("session_images", (List<Image>) wallet.getLocation(id).getImages());
        return new ResponseEntity<>(wallet.getLocation(id), HttpStatus.OK);
    }
}
