package com.lamaro.pokemon.services;

import com.lamaro.pokemon.model.PokemonType;
import com.lamaro.pokemon.repository.PokemonTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private final PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public PokemonType createPokemonType(PokemonType pokemonType) {
        pokemonType.setId(null);
        return pokemonTypeRepository.save(pokemonType);
    }

    @Override
    public PokemonType findPokemonTypeById(Long id) throws Exception {
        if (pokemonTypeRepository.findPokemonTypeById(id) == null) {
            throw new Exception("No Pokemon Type for that ID!!");
        } else {
            return pokemonTypeRepository.findPokemonTypeById(id);
        }
    }

    @Override
    public Page<PokemonType> findAllPokemonTypes(Pageable pageable) {
        return pokemonTypeRepository.findAll(pageable);
    }

    @Override
    public PokemonType updatePokemonType(PokemonType pokemonType) throws Exception {
        if (pokemonTypeRepository.existsById(pokemonType.getId())) {
            return pokemonTypeRepository.save(pokemonType);
        } else {
            throw new Exception("Pokemon Type not there!");
        }
    }

    @Override
    public String deletePokemonTypeById(Long id) {
        pokemonTypeRepository.deleteById(id);
        if (pokemonTypeRepository.findPokemonTypeById(id) == null) {
            return "Delete successful!";
        } else {
            return "Delete not successful!!!!!!";
        }
    }
}
