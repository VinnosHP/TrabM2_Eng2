package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import services.Facade;

@Controller
public class AnswerController {

    @Autowired
    private Facade facade;

    @GetMapping("/responder")
    public String showAnswerPage() {
        return "html/responderPergunta.html";
    }

}
