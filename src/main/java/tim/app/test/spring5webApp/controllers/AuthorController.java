package tim.app.test.spring5webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tim.app.test.spring5webApp.repositories.AuthorRepository;

@Controller
public class AuthorController {

    private AuthorRepository aRep;

    public AuthorController(AuthorRepository aRep) {
        this.aRep = aRep;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", aRep.findAll());
        return "authors";
    }
}
