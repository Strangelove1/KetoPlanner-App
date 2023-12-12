package pl.strangelove.objects.mealIngredients;

import jakarta.persistence.*;
import lombok.*;
import pl.strangelove.objects.ingredients.Ingredient;
import pl.strangelove.objects.meals.Meal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "meal_ingredients")
public class MealIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
}
