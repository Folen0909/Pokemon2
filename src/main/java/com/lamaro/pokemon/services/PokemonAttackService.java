package com.lamaro.pokemon.services;

import com.lamaro.pokemon.model.PokemonAttack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PokemonAttackService {

    PokemonAttack createPokemonAttack(PokemonAttack pokemonAttack);

    PokemonAttack findPokemonAttackById(Long id) throws Exception;

    Page<PokemonAttack> findAllAttacks(Pageable pageable);

    PokemonAttack updatePokemonAttack(PokemonAttack pokemonAttack) throws Exception;

    String deletePokemonAttacksById(Long id);

}
