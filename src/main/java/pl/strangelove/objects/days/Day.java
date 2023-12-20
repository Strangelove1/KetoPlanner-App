package pl.strangelove.objects.days;

import jakarta.persistence.*;
import lombok.*;
import pl.strangelove.objects.dayNames.DayNames;
import pl.strangelove.objects.meals.Meal;
import pl.strangelove.objects.users.User;
import pl.strangelove.objects.weeks.Week;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Week weeks;
    @ManyToOne
    private DayNames dayNames;
    private int kcal;
    private int carbohydrates;
    private boolean isKetoFriendly;
    @ManyToOne
    private User user;
    private LocalDate created;

    @ManyToMany
    @JoinTable(
            name = "Days_Meals",
            joinColumns = @JoinColumn(name = "day_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;
}
