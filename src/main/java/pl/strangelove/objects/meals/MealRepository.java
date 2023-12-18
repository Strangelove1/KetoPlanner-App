package pl.strangelove.objects.meals;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findMealsByUser_Id(Integer userId);
}
