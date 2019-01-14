package tim.app.test.spring5webApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tim.app.test.spring5webApp.repositories.BookRepository;

@Controller
public class BookController {

    private BookRepository bRep;

    public BookController(BookRepository bRep) {
        this.bRep = bRep;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bRep.findAll());
        return "books";
    }
}
