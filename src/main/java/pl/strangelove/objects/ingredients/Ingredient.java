package pl.strangelove.objects.ingredients;

import jakarta.persistence.*;
import lombok.*;
import pl.strangelove.objects.meals.Meal;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int carbohydrates;
    private double weight;
    private int kcal;
    @ManyToMany(mappedBy = "ingredientsList")
    private List<Meal> meals;
}
