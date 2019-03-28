package com.lamaro.pokemon.repository;

import com.lamaro.pokemon.model.PokemonAttack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PokemonAttackRepository extends PagingAndSortingRepository<PokemonAttack, Long> {

    PokemonAttack findPokemonAttacksById(Long id);

    Page<PokemonAttack> findAll(Pageable pageable);


}
