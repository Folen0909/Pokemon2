package com.lamaro.pokemon.services;

import com.lamaro.pokemon.model.Pokemon;
import com.lamaro.pokemon.model.PokemonType;
import com.lamaro.pokemon.repository.PokemonRepository;
import com.lamaro.pokemon.repository.PokemonTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonTypeRepository pokemonTypeRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    private Pokemon makingPokemonBlank(Pokemon pokemon) throws Exception {

        pokemon.setId(null);
        Set<PokemonType> types = pokemon.getPokemonType();
        Set<PokemonType> temp = new HashSet<>();
        for (PokemonType pokemonType : types) {
            if (!pokemonTypeRepository.existsById(pokemonType.getId())) {
                throw new Exception("That type does not exists!!!!!");
            }
            temp.add(pokemonTypeRepository.findPokemonTypeById(pokemonType.getId()));
        }
        pokemon.setPokemonType(temp);
        return pokemon;
    }

    @Override
    public Pokemon createPokemon(Pokemon pokemon) throws Exception {
        return pokemonRepository.save(makingPokemonBlank(pokemon));
    }

    @Override
    public List<Pokemon> createMultiplePokemons(List<Pokemon> pokemons) throws Exception {
        for (Pokemon pokemon:pokemons) makingPokemonBlank(pokemon);
        return (List<Pokemon>) pokemonRepository.saveAll(pokemons);
    }

    @Override
    public Pokemon findPokemonById(Long id) throws Exception {
        if (pokemonRepository.findPokemonById(id) == null) {
            throw new Exception("No Pokemon for that ID!!");
        } else {
            return pokemonRepository.findPokemonById(id);
        }
    }

    @Override
    public Pokemon findRandomPokemon() {
        Random rand = new Random();
        return pokemonRepository.findPokemonById((long) rand.nextInt((int) pokemonRepository.count()));
    }

    @Override
    public Page<Pokemon> findPokemonsByPokemonTypeId(List<Long> id, Pageable pageable) {
        return pokemonRepository.findPokemonsByPokemonTypeIdIn(id, pageable);
    }

    @Override
    public Page<Pokemon> findAllPokemons(Pageable pageable) {
        return pokemonRepository.findAll(pageable);
    }

    @Override
    public Pokemon updatePokemon(Pokemon pokemon) throws Exception {
        if (pokemonRepository.existsById(pokemon.getId())) {
            return pokemonRepository.save(pokemon);
        } else {
            throw new Exception("Pokemon not there!");
        }
    }

    @Override
    public String deletePokemonById(Long id) {
        pokemonRepository.deleteById(id);
        if (pokemonRepository.findPokemonById(id) == null) {
            return "Delete successful!";
        } else {
            return "Delete not successful!!!!!!";
        }
    }

    @Override
    public String deleteMultiplePokemons(List<Pokemon> pokemons) throws Exception {
            pokemonRepository.deleteAll(pokemons);
            if (!(pokemons.get(0).getId() == null)) {
                return "Delete successful!";
            } else {
                return "Delete not successful!!!!!!";
            }

    }
}
