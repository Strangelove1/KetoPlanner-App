package pl.strangelove.objects.meals;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.strangelove.objects.ingredients.Ingredient;
import pl.strangelove.objects.ingredients.IngredientRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/meals")
public class MealController {
    private final MealRepository mealRepository;
    private final IngredientRepository ingredientRepository;

    public MealController(MealRepository mealRepository, IngredientRepository ingredientRepository)
    {
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/mealDetails/{id}")
    public String showMealDetails(Model model, @PathVariable Long id){
        Meal meal = mealRepository.findById(id).orElse(null);
        List<Ingredient> ingredientList = meal.getIngredientsList();
        model.addAttribute("ingredientList", ingredientList);
        return "meal/mealDetails";
    }

    @GetMapping("/list")
    public String getAllMeals(Model model) {
        List<Meal> mealList = mealRepository.findAll();
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
    public String saveMeal(@ModelAttribute @Validated Meal meal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "meal/addMeal";
        }
        mealRepository.save(meal);
        return "redirect:/meal/list";
    }

    @GetMapping("/editMeal/{id}")
    public String editIngredient(@PathVariable Long id, Model model) {
       Meal meal = mealRepository.findById(id).orElse(null);
        model.addAttribute("updatemeal", meal);
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "meal/editMeal";
    }

    @PostMapping("/editMeal/{id}")
    public String updateMeal(@PathVariable Long id, @ModelAttribute Meal meal) {
        Meal mealToUpdate = mealRepository.findById(id).orElse(null);

        if (mealToUpdate != null){
            mealToUpdate.setName(meal.getName());
            mealToUpdate.setDescription(meal.getDescription());
            mealToUpdate.setKcal(mealToUpdate.getKcal());
            mealToUpdate.setCarbohydrates(meal.getCarbohydrates());
            mealToUpdate.setUser(meal.getUser());
            mealToUpdate.setIngredientsList(meal.getIngredientsList());
            mealRepository.save(mealToUpdate);

        }
        return "redirect:/meal/list";
    }

    @GetMapping("/deleteMeal/{id}")
    public String deleteMeal(@PathVariable Long id) {
        mealRepository.deleteById(id);
        return "redirect:/meal/list";
    }
}