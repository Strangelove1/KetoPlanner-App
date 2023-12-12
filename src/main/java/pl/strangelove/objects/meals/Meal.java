package pl.strangelove.objects.meals;

import jakarta.persistence.*;
import lombok.*;
import pl.strangelove.objects.ingredients.Ingredient;
import pl.strangelove.objects.users.User;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int carbohydrates;
    private int kcal;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(
            name = "meal_ingredients",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredientsList;



}
