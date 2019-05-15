package be.springPressOrder.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "Entries")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class Entry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;

    // Each user has her own entries
    @JsonBackReference
    @ManyToOne
    private User user;

    @ManyToOne
    private PressOrder pressOrder;

    @ManyToOne
    private Order order;
    private LocalDateTime dateTimeFrom, dateTimeTo;
    private Duration duration;

    /*@ManyToOne
    private Objective objective;
    private String description;*/
}
