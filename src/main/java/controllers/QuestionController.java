package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import services.Facade;
import web.dto.QuestionForm;

@Controller
public class QuestionController {

    @Autowired
    private Facade facade;

    @GetMapping("/perguntas")
    public String showQuestionPage(Model model) {
        model.addAttribute("perguntas", facade.getAllUsersQuestions());
        return "html/listaDePerguntas.html";
    }

    @GetMapping("/novaPergunta")
    public String showCreateQuestionForm(Model model) {
        model.addAttribute("questionForm", new QuestionForm());
        return "html/criaPergunta.html";
    }

    @PostMapping("/novaPergunta")
    public String createNewQuestion(Model model, @ModelAttribute QuestionForm form,
            RedirectAttributes redirectAttributes) {
        try {
            form.setUserPk(1);
            facade.insertQuestion(form); // tem que pegar o userPk pelo email
            return "redirect:/perguntas";
        } catch (Exception e) {
            model.addAttribute("error", "Falha ao inserir a pergunta");
            return "redirect:/novaPergunta";
        }
    }
}
