package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.interfaces.IUserRepo;
import webapp.dto.UserForm;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

    @Autowired
    private IUserRepo userRepo;

    // Paths

    private static final String DETAILS_PATH = "/details/{pk}";

    private static final String DELETE_PATH = "/delete/{pk}";

    private static final String UPDATE_PATH = "/update";

    private static final String ADD_PATH = "/add";

    // HTTP methods

    @RequestMapping(value = DETAILS_PATH, method = RequestMethod.GET)
    public String getDetails(@PathVariable("userPk") Integer userPk, Model model) {
        UserForm userDetails = userRepo.getUser(userPk);

        model.addAttribute("userDetails", userDetails);

        return "data-man/userDetail"; // modificar esse data-man

    }

    @RequestMapping(value = DELETE_PATH, method = RequestMethod.POST)
    public String delete(@PathVariable("userPk") Integer userPk, Model model) {

        userRepo.deleteUser(userPk);

        return "redirect:/admin/questions"; // modificar esse data-man
    }

    @RequestMapping(params = "update", value = UPDATE_PATH, method = RequestMethod.POST)
    public String update(@ModelAttribute("userForm") UserForm userForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "data-man/userDetail";
        }

        return "redirect:/admin/questions"; // modificar esse data-man

    }

    @RequestMapping(params = "add", value = ADD_PATH, method = RequestMethod.POST)
    public String add(@ModelAttribute("userForm") UserForm userForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "data-man/userAdd";
        }

        userRepo.createNewUser(userForm);

        return "redirect:/admin/questions"; // modificar esse data-man
    }
}
