package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.interfaces.IQuestionRepo;
import webapp.dto.QuestionForm;

@Controller
@RequestMapping(value = "/admin/questions")
public class QuestionController {

    @Autowired
    private IQuestionRepo questionRepo;

    private static final String PARAMS = "params";

    // Paths

    private static final String DETAILS_PATH = "/details/{pk}";

    private static final String DELETE_PATH = "/delete/{pk}";

    private static final String UPDATE_PATH = "/update";

    private static final String ADD_PATH = "/add";

    // HTTP methods

    @RequestMapping(method = RequestMethod.GET)
    public String getOverView(Model model) {
        initList(model, new QuestionForm());

        return "data-man/questions";
    }

    @RequestMapping(value = DETAILS_PATH, method = RequestMethod.GET)
    public String getDetails(@PathVariable("questionPk") Integer questionPk, Model model) {
        QuestionForm questionDetails = questionRepo.getQuestion(questionPk);

        model.addAttribute("questionDetails", questionDetails);

        return "data-man/questionDetail"; // modificar esse data-man

    }

    @RequestMapping(value = DELETE_PATH, method = RequestMethod.POST)
    public String delete(@PathVariable("questionPk") Integer questionPk, Model model) {

        questionRepo.deleteQuestion(questionPk);

        return "redirect:/admin/questions"; // modificar esse data-man
    }

    @RequestMapping(params = "update", value = UPDATE_PATH, method = RequestMethod.POST)
    public String update(@ModelAttribute("questionForm") QuestionForm questionForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "data-man/questionDetail";
        }

        return "redirect:/admin/questions"; // modificar esse data-man

    }

    @RequestMapping(params = "add", value = ADD_PATH, method = RequestMethod.POST)
    public String add(@ModelAttribute("questionForm") QuestionForm questionForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "data-man/questionAdd";
        }

        questionRepo.insertQuestion(questionForm);

        return "redirect:/admin/questions"; // modificar esse data-man
    }

    private void initList(Model model, QuestionForm params) {

        model.addAttribute(PARAMS, params);
        model.addAttribute("list", questionRepo.getAllUsersQuestions(params));
    }

    // "redirect:/admin/nfeTenants"
}
