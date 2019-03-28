package com.lamaro.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon extends BaseEntity {

    //pokušati sa veznim entitetom

    private Long health;
    private Long ordinalNumber;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pokemon_types",
            joinColumns = {@JoinColumn(name = "pokemon_id")},
            inverseJoinColumns = {@JoinColumn(name = "pokemon_type_id")}
    )
    private Set<PokemonType> pokemonType = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PokemonAttack> attacks = new HashSet<>();
}
