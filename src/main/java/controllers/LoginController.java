package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import services.Facade;
import web.dto.UserForm;

@Controller
public class LoginController {

    @Autowired
    private Facade facade;

    @GetMapping("/login")
    public String showLoginPage() {
        return "index.html";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute UserForm userform, RedirectAttributes redirectAttributes) {
        boolean loginSuccess = facade.login(userform.getUserEmail(), userform.getUserPassword());
        System.out.println("Lista de usuarios: " + facade.getUsersList());
        if (loginSuccess) {
            return "redirect:perguntas";
        } else {
            // por p ver msg de erro
            return "redirect:/login";
        }
    }

    @GetMapping("/cadastro")
    public String showCadastroPage() {
        return "html/cadastro.html";
    }

    @PostMapping("/html/cadastro")
    public String cadastrarNovoUsuario(@ModelAttribute UserForm userForm, RedirectAttributes redirectAttributes) {
        facade.createNewUser(userForm);
        return "redirect:/login";
    }
}
