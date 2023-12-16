package pl.strangelove.objects.weeks;


import jakarta.persistence.*;
import lombok.*;
import pl.strangelove.objects.days.Day;
import pl.strangelove.objects.users.User;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "weeks")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String weekName;
    private LocalDate created;
    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "Weeks_Days",
            joinColumns = @JoinColumn(name = "week_id"),
            inverseJoinColumns = @JoinColumn(name = "day_id")
    )
    private List<Day> days;
}
