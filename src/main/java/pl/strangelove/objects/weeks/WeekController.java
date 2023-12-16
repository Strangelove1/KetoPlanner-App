package pl.strangelove.objects.weeks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.strangelove.objects.days.DayRepository;

import java.util.List;

@Controller
@RequestMapping("/weeks")
public class WeekController {

    private final WeekRepository weekRepository;
    private final DayRepository dayRepository;

    public WeekController(WeekRepository weekRepository, DayRepository dayRepository) {
        this.dayRepository = dayRepository;
        this.weekRepository = weekRepository;
    }

    @GetMapping("/showAllWeeks")
    public String getAllWeeks(Model model) {
        List<Week> weekList = weekRepository.findAll();
        model.addAttribute("weeks", weekList);
        return "weeks/list";
    }

    @GetMapping("/create")
    public String createWeek(Model model) {
        model.addAttribute("week", new Week());
        model.addAttribute("days", dayRepository.findAll());
        return "weeks/create";
    }

    @PostMapping("/create")
    public String saveWeek(@ModelAttribute @Validated Week week, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "week/add";
        }
        weekRepository.save(week);
        return "redirect:/weeks/showAllWeeks";
    }

    @GetMapping("/editWeek/{id}")
    public String editWeek(Model model, @PathVariable Long id){
        Week week = weekRepository.findById(id).orElse(null);
        model.addAttribute("week", week);
        model.addAttribute("days", weekRepository.findAll());
        return "week/editWeek";
    }

    @PostMapping("/editWeek/{id}")
    public String updateWeek(@ModelAttribute Week week, @PathVariable Long id ){
        Week weekToUpdate = weekRepository.findById(id).orElse(null);

        if (weekToUpdate != null){
            weekToUpdate.setWeekName(week.getWeekName());
            weekToUpdate.setDays(week.getDays());
            weekToUpdate.setUser(week.getUser());
            weekToUpdate.setId(week.getId());
            weekToUpdate.setCreated(week.getCreated());
            weekRepository.save(weekToUpdate);
        }
        return "redirect:/week/list";
    }

    @GetMapping("/deleteWeek/{id}")
    public String deleteWeek(@PathVariable Long id){
        weekRepository.deleteById(id);
        return "redirect/week/list";
    }


}
