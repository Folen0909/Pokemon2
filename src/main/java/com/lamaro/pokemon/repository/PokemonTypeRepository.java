package com.lamaro.pokemon.repository;

import com.lamaro.pokemon.model.PokemonType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PokemonTypeRepository extends PagingAndSortingRepository<PokemonType, Long> {

    PokemonType findPokemonTypeById(Long id);

    Page<PokemonType> findAll(Pageable pageable);

}
