package pl.strangelove.objects.days;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strangelove.objects.weeks.Week;

import java.util.List;

public interface DayRepository extends JpaRepository<Day, Long> {
List<Day> findDaysByUser_Id(Integer userId);
List<Day> getDaysByWeeks_Id(int weekId);

}
