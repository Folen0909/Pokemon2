package com.lamaro.pokemon.services;

import com.lamaro.pokemon.model.PokemonAttack;
import com.lamaro.pokemon.repository.PokemonAttackRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PokemonAttackServiceImpl implements PokemonAttackService {

    private final PokemonAttackRepository pokemonAttackRepository;

    public PokemonAttackServiceImpl(PokemonAttackRepository pokemonAttackRepository) {
        this.pokemonAttackRepository = pokemonAttackRepository;
    }


    @Override
    public PokemonAttack createPokemonAttack(PokemonAttack pokemonAttack) {
        pokemonAttack.setId(null);
        return pokemonAttackRepository.save(pokemonAttack);
    }

    @Override
    public PokemonAttack findPokemonAttackById(Long id) throws Exception {
        if (pokemonAttackRepository.existsById(id)) {
            return pokemonAttackRepository.findPokemonAttacksById(id);
        } else {
            throw new Exception("Pokemon Attack does not exists!!!!!!!!!!");
        }
    }

    @Override
    public Page<PokemonAttack> findAllAttacks(Pageable pageable) {
        return pokemonAttackRepository.findAll(pageable);
    }

    @Override
    public PokemonAttack updatePokemonAttack(PokemonAttack pokemonAttack) throws Exception {
        if (pokemonAttackRepository.existsById(pokemonAttack.getId())) {
            return pokemonAttackRepository.save(pokemonAttack);
        } else {
            throw new Exception("Pokemon Attack does not exists!!!!!!!!!!");
        }

    }

    @Override
    public String deletePokemonAttacksById(Long id) {
        pokemonAttackRepository.deleteById(id);
        if (pokemonAttackRepository.findPokemonAttacksById(id) == null) {
            return "Delete successful!";
        } else {
            return "Delete not successful!!!!!!";
        }
    }
}
