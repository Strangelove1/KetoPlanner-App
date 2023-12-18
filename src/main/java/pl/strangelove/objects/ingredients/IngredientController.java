package pl.strangelove.objects.ingredients;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.strangelove.objects.meals.Meal;

import java.util.List;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping("/showAllIngredients")
    public String getAllIngredients(Model model) {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredientList);
        return "ingredient/list";
    }

    @GetMapping("/create")
    public String createIngredient(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredient/addIngredient";
    }

    @PostMapping("/create")
    public String saveIngredient(@ModelAttribute Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return "redirect:/ingredient/showAllIngredients";
    }

    @GetMapping("/editIngredient/{id}")
    public String editIngredient(@PathVariable Long id, Model model) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
        model.addAttribute("ingredient", ingredient);
        return "ingredient/updateIngredient";
    }

    @PostMapping("/editIngredient/{id}")
    public String updateIngredient(@PathVariable Long id, @ModelAttribute Ingredient ingredient) {
        Ingredient ingredientToUpdate = ingredientRepository.findById(id).orElse(null);

        if (ingredientToUpdate != null) {
            ingredientToUpdate.setName(ingredient.getName());
            ingredientToUpdate.setKcal(ingredient.getKcal());
            ingredientToUpdate.setWeight(ingredient.getWeight());
            ingredientToUpdate.setCarbohydrates(ingredient.getCarbohydrates());
            ingredientToUpdate.setDescription(ingredient.getDescription());
            ingredientRepository.save(ingredientToUpdate);
        }

        return "redirect:/ingredient/showAllIngredients";
    }

    @GetMapping("/deleteIngredient/{id}")
    public String deleteIngredient(@PathVariable Long id) {
        ingredientRepository.deleteById(id);
        return "redirect:/ingredient/showAllIngredients";
    }
}