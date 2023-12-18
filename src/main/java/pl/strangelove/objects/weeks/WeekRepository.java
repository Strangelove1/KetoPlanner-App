package pl.strangelove.objects.weeks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeekRepository extends JpaRepository<Week, Long> {
    List<Week> getWeeksByUser_Id(Integer userId);
}
