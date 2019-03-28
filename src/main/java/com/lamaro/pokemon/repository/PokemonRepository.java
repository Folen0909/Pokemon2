package com.lamaro.pokemon.repository;

import com.lamaro.pokemon.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface PokemonRepository  extends PagingAndSortingRepository<Pokemon, Long> {

    Pokemon findPokemonById(Long id);

    Page<Pokemon> findAll(Pageable pageable);

    Page<Pokemon> findPokemonsByPokemonTypeIdIn(List<Long> id, Pageable pageable);

}
