package pl.strangelove.objects.days;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.strangelove.objects.dayNames.DayNameRepository;
import pl.strangelove.objects.meals.MealRepository;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/days")
public class DayController {

    private final DayRepository dayRepository;
    private final MealRepository mealRepository;
    private final DayNameRepository dayNameRepository;

    public DayController(DayRepository dayRepository, MealRepository mealRepository, DayNameRepository dayNameRepository) {
        this.dayRepository = dayRepository;
        this.mealRepository = mealRepository;
        this.dayNameRepository = dayNameRepository;
    }

    @GetMapping("/list")
    public String getAllDays(Model model) {
        List<Day> dayList = dayRepository.findAll();
        model.addAttribute("days", dayList);
        return "day/list";
    }

    @GetMapping("/create")
    public String createDay(Model model) {
        model.addAttribute("day", new Day());
        model.addAttribute("meals", mealRepository.findAll());
        model.addAttribute("dayNames", dayNameRepository.findAll());
        return "day/addDay";
    }

    @PostMapping("/create")
    public String saveDay(@ModelAttribute @Validated Day day, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "day/addDay";
        }
        dayRepository.save(day);
        return "redirect:/days/list";
    }

    @GetMapping("/editDay/{id}")
    public String editDay(Model model, @PathVariable Long id) {
        Day day = dayRepository.findById(id).orElse(null);
        model.addAttribute("day", day);
        model.addAttribute("meals", mealRepository.findAll());
        model.addAttribute("dayNames", dayNameRepository.findAll());
        return "day/editDay";
    }

    @PostMapping("/editDay/{id}")
    public String updateDay(@PathVariable Long id, @ModelAttribute Day day) {
        Day dayToUpdate = dayRepository.findById(id).orElse(null);

        if (dayToUpdate != null) {
            dayToUpdate.setDayNames(day.getDayNames());
            dayToUpdate.setId(day.getId());
            dayToUpdate.setKcal(day.getKcal());
            dayToUpdate.setMeals(day.getMeals());
            dayToUpdate.setUser(day.getUser());
            dayToUpdate.setCarbohydrates(day.getCarbohydrates());
            dayToUpdate.setCreated(day.getCreated());
            dayRepository.save(dayToUpdate);
        }

        return "redirect:/day/list";
    }

    @GetMapping("/deleteDay/{id}")
    public String deleteDay(@PathVariable Long id) {
        dayRepository.deleteById(id);
        return "redirect:/day/list";
    }
}
