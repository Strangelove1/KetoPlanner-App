package pl.strangelove.objects.dayNames;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "dayNames")
public class DayNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int order;
    private String name;
}
