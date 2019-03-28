package com.lamaro.pokemon.services;

import com.lamaro.pokemon.model.PokemonType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PokemonTypeService {

    PokemonType createPokemonType(PokemonType pokemonType);

    PokemonType findPokemonTypeById(Long id) throws Exception;

    Page<PokemonType> findAllPokemonTypes(Pageable pageable);

    PokemonType updatePokemonType(PokemonType pokemonType) throws Exception;

    String deletePokemonTypeById(Long id);

}
