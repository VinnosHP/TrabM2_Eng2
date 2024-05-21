package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.interfaces.IAnswerRepo;
import repositories.interfaces.IUserRepo;
import services.interfaces.IAnswer;
import web.dto.AnswerForm;

import org.springframework.web.bind.annotation.RequestParam;

import models.User;
import observers.implementations.UserObserver;

@Controller
@RequestMapping(value = "/admin/answer")
public class AnswerController {

    @Autowired
    private IAnswerRepo answerRepo;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private IAnswer answerService;

    // Paths

    private static final String DETAILS_PATH = "/details/{pk}";

    private static final String DELETE_PATH = "/delete/{pk}";

    private static final String UPDATE_PATH = "/update";

    private static final String ADD_PATH = "/add";

    private static final String OBSERVER_PATH = "/observe";

    // HTTP methods

    // @RequestMapping(value = DETAILS_PATH, method = RequestMethod.GET)
    // public String getDetails(@PathVariable("userPk") Integer userPk, Model model)
    // {
    // UserForm userDetails = userRepo.getUser(userPk);

    // model.addAttribute("userDetails", userDetails);

    // return "data-man/userDetail"; // modificar esse data-man

    // }

    @RequestMapping(value = DELETE_PATH, method = RequestMethod.POST)
    public String delete(@PathVariable("answerPk") Integer answerPk, Model model) {

        answerRepo.deleteAnswer(answerPk);

        return "redirect:/admin/question"; // modificar esse data-man
    }

    @RequestMapping(params = "update", value = UPDATE_PATH, method = RequestMethod.POST)
    public String update(@ModelAttribute("answerForm") AnswerForm answerForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "data-man/questionDetail";
        }

        return "redirect:/admin/answer"; // modificar esse data-man

    }

    @RequestMapping(params = "add", value = ADD_PATH, method = RequestMethod.POST)
    public String add(@ModelAttribute("answerForm") AnswerForm answerForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "data-man/answerAdd";
        }

        answerRepo.insertAnswer(answerForm);

        return "redirect:/admin/question"; // modificar esse data-man
    }

    @RequestMapping(params = "observe", value = OBSERVER_PATH, method = RequestMethod.POST)
    public String observe(@RequestParam Integer questionPk, @RequestParam Integer userPk) {
        User user = new User();
        user.setUserPk(userPk);
        user.setName(userRepo.getUser(userPk).getUserName());

        UserObserver observer = new UserObserver(user);

        answerService.attachObserver(observer);

        return "redirect:/admin/question";
    }
}
