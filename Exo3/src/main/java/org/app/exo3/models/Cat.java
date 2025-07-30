package org.app.exo3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String race;
    private String favoriteFood;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    public Cat(String name, String race, String favoriteFood, LocalDate birthDate) {
        this.name = name;
        this.race = race;
        this.favoriteFood = favoriteFood;
        this.birthDate = birthDate;
    }
}
