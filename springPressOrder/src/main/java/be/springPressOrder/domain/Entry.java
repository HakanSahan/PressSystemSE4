package be.springPressOrder.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ENTRIES")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class Entry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;

    // Each user has her own entries
    @ManyToOne
    private User user;

    @ManyToOne
    private PressOrder pressOrder;

    @ManyToOne
    private Order order;
    /*@ManyToOne
    private Objective objective;

    private LocalDateTime dateTimeFrom, dateTimeTo;
    private Duration duration;

    private String description;*/
}
