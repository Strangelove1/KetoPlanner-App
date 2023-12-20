package pl.strangelove.objects.weeks;

import jakarta.servlet.http.HttpSession;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.strangelove.objects.dayNames.DayNameRepository;
import pl.strangelove.objects.days.Day;
import pl.strangelove.objects.days.DayRepository;
import pl.strangelove.objects.users.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/weeks")
public class WeekController {

    private final WeekRepository weekRepository;
    private final DayRepository dayRepository;
    private final DayNameRepository dayNameRepository;

    public WeekController(DayNameRepository dayNameRepository, WeekRepository weekRepository, DayRepository dayRepository) {
        this.dayRepository = dayRepository;
        this.weekRepository = weekRepository;
        this.dayNameRepository = dayNameRepository;
    }

    @GetMapping("/list")
    public String getAllWeeks(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int adminId = user.getId();
        List<Week> weekList = weekRepository.getWeeksByUser_Id(adminId);
        Map<Week, List<Day>> weekDaysMap = new HashMap<>();
        for (Week week : weekList) {
            List<Day> days = dayRepository.getDaysByWeeks_Id(week.getId());
            weekDaysMap.put(week, days);
        }
        model.addAttribute("weekDaysMap", weekDaysMap);
        model.addAttribute("weeks", weekList);
        return "week/list";
    }

    @GetMapping("/create")
    public String createWeek(Model model) {
        Week week = new Week();
        model.addAttribute("week", week);
        return "week/addWeek";
    }

    @PostMapping("/create")
    public String saveWeek(@ModelAttribute @Validated Week week, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "week/addWeek";
        }
        LocalDate localDate = LocalDate.now();
        User user = (User) session.getAttribute("user");
        week.setCreated(localDate);
        week.setUser(user);
        weekRepository.save(week);
        return "redirect:/weeks/list";
    }

    @GetMapping("/updateWeek/{id}")
    public String editWeek(Model model, @PathVariable Long id){
        Week week = weekRepository.findById(id).orElse(null);
        model.addAttribute("week", week);
        model.addAttribute("days", weekRepository.findAll());
        return "week/updateWeek";
    }

    @PostMapping("/updateWeek/{id}")
    public String updateWeek(@ModelAttribute Week week, @PathVariable Long id, HttpSession session ){
        Week weekToUpdate = weekRepository.findById(id).orElse(null);
        LocalDate localDate = LocalDate.now();
        User user = (User) session.getAttribute("user");
        if (weekToUpdate != null){
            weekToUpdate.setWeekName(week.getWeekName());
            weekToUpdate.setUser(user);
            weekToUpdate.setId(week.getId());
            weekToUpdate.setCreated(localDate);
            weekRepository.save(weekToUpdate);
        }
        return "redirect:/weeks/list";
    }

    @GetMapping("/deleteWeek/{id}")
    public String deleteWeek(@PathVariable Long id){
        weekRepository.deleteById(id);
        return "redirect:/weeks/list";
    }


}
