package pl.strangelove;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "book/add";
    }
}
