package pl.strangelove;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class helloController {

    private final BookRepository bookRepository;

    public helloController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/")
    public String hi(){

        Book book = new Book();
        book.getTitle();
        Book build = Book.builder().title("thinking in Java").description("Dupa psa").build();
        bookRepository.save(build);
        log.info("coś tam", book.getTitle());
        return "book/test";
    }

}
