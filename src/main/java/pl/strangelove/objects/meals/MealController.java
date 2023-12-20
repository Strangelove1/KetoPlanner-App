package pl.strangelove.objects.meals;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.strangelove.objects.ingredients.Ingredient;
import pl.strangelove.objects.ingredients.IngredientRepository;
import pl.strangelove.objects.users.User;
import pl.strangelove.objects.users.UserRepository;

import java.util.List;
@Controller
@RequestMapping("/meals")
public class MealController {
    private final MealRepository mealRepository;
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;

    public MealController(UserRepository userRepository, MealRepository mealRepository, IngredientRepository ingredientRepository)
    {
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/mealDetails/{id}")
    public String showMealDetails(Model model, @PathVariable Long id){
        Meal meal = mealRepository.findById(id).orElse(null);
        List<Ingredient> ingredientList = meal.getIngredientsList();
        model.addAttribute("ingredientList", ingredientList);
        return "meal/mealDetails";
    }

    @GetMapping("/list")
    public String getAllMeals(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int adminId = user.getId();
        List<Meal> mealList = mealRepository.findMealsByUser_Id(adminId);
        model.addAttribute("meals", mealList);
        return "meal/list";
    }

    @GetMapping("/create")
    public String createMeal(Model model) {
        model.addAttribute("meal", new Meal());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "meal/addMeal";
    }

    @PostMapping("/create")
    public String saveMeal(@ModelAttribute @Validated Meal meal, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()){
            return "meal/addMeal";
        }
        calculateAndSetMealTotals(meal);
        User user = (User) session.getAttribute("user");
        meal.setUser(user);
        mealRepository.save(meal);
        return "redirect:/meals/list";
    }

    @GetMapping("/updateMeal/{id}")
    public String editIngredient(@PathVariable Long id, Model model) {
       Meal meal = mealRepository.findById(id).orElse(null);
        model.addAttribute("meal", meal);
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "meal/updateMeal";
    }

    @PostMapping("/updateMeal/{id}")
    public String updateMeal(@PathVariable Long id, @ModelAttribute Meal meal, HttpSession session) {
        Meal mealToUpdate = mealRepository.findById(id).orElse(null);
        User user = (User) session.getAttribute("user");

        if (mealToUpdate != null){
            mealToUpdate.setName(meal.getName());
            mealToUpdate.setDescription(meal.getDescription());
            mealToUpdate.setKcal(mealToUpdate.getKcal());
            mealToUpdate.setCarbohydrates(meal.getCarbohydrates());
            mealToUpdate.setUser(user);
            mealToUpdate.setIngredientsList(meal.getIngredientsList());
            calculateAndSetMealTotals(mealToUpdate);

            mealRepository.save(mealToUpdate);

        }
        return "redirect:/meals/list";
    }

    @GetMapping("/deleteMeal/{id}")
    public String deleteMeal(@PathVariable Long id) {
        mealRepository.deleteById(id);
        return "redirect:/meals/list";
    }

    // Method for counting carb and kcal totals from ingredients in each meal
    private void calculateAndSetMealTotals(Meal meal) {
        int totalKcal = 0;
        int totalCarbohydrates = 0;

        for (Ingredient ingredient : meal.getIngredientsList()) {
            totalKcal += ingredient.getKcal();
            totalCarbohydrates += ingredient.getCarbohydrates();
        }

        meal.setKcal(totalKcal);
        meal.setCarbohydrates(totalCarbohydrates);
    }
}