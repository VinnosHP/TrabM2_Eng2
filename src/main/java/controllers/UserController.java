package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import services.Facade;

@Controller
public class UserController {

    @Autowired
    private Facade facade;

    @GetMapping("/perfil")
    public String showProfilePage(Model model) {
        return "html/perfil.html";
    }

}
