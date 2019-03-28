package com.lamaro.pokemon.services;

import com.lamaro.pokemon.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PokemonService {

    Pokemon createPokemon(Pokemon pokemon) throws Exception;

    List<Pokemon> createMultiplePokemons(List<Pokemon> pokemons) throws Exception;

    Pokemon findPokemonById(Long id) throws Exception;

    Pokemon findRandomPokemon();

    Page<Pokemon> findPokemonsByPokemonTypeId(List<Long> id, Pageable pageable);

    Page<Pokemon> findAllPokemons(Pageable pageable);

    Pokemon updatePokemon(Pokemon pokemon) throws Exception;

    String deletePokemonById(Long id);

    String deleteMultiplePokemons(List<Pokemon> pokemons) throws Exception;
}
