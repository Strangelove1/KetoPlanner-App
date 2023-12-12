package pl.strangelove.objects.weeks;


import jakarta.persistence.*;
import lombok.*;
import pl.strangelove.objects.users.User;

import java.time.LocalDate;

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

}
