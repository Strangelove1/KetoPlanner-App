package pl.strangelove;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.strangelove.objects.meals.MealRepository;

@Controller
@Slf4j
public class helloController {

    private final BookRepository bookRepository;
    private final MealRepository mealRepository;

    public helloController(BookRepository bookRepository, MealRepository mealRepository) {
        this.bookRepository = bookRepository;
        this.mealRepository = mealRepository;
    }


    @RequestMapping("/")
    public String hi(){

        Book book = new Book();
        book.getTitle();
        Book build = Book.builder().title("thinking in Java").description("Dupa psa").build();
        bookRepository.save(build);
        log.info("coś tam", book.getTitle());
        mealRepository.findAll();

        return "homepage/homepage";
    }

}
