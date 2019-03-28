package com.lamaro.pokemon.controller;

import com.lamaro.pokemon.model.Pokemon;
import com.lamaro.pokemon.services.PokemonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PokemonController {

    private final PokemonService pokemonService;


    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/pokemon/new")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) throws Exception {
        return ResponseEntity.ok(pokemonService.createPokemon(pokemon));
    }

    @PostMapping("/pokemon/new/list")
    public ResponseEntity<List<Pokemon>> createMultiplePokemons(@RequestBody List<Pokemon> pokemons) throws Exception {
        return ResponseEntity.ok(pokemonService.createMultiplePokemons(pokemons));
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> showPokemonById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(pokemonService.findPokemonById(id));
    }

    @GetMapping("/pokemon/random")
    public ResponseEntity<Pokemon> showRandomPokemon() {
        return ResponseEntity.ok(pokemonService.findRandomPokemon());
    }

    @GetMapping(value = "/pokemon", params = "list")
    public ResponseEntity<Page<Pokemon>> showAllPokemons(@PageableDefault(size = 20, sort = "ordinalNumber") Pageable pageable) {
        return ResponseEntity.ok(pokemonService.findAllPokemons(pageable));
    }

    @GetMapping(value = "/pokemon", params = "type")
    public ResponseEntity<Page<Pokemon>> showPokemonsByPokemonType(@RequestParam List<Long> type, @PageableDefault(size = 20, sort = "ordinalNumber") Pageable pageable) {
        return ResponseEntity.ok(pokemonService.findPokemonsByPokemonTypeId(type, pageable));
    }


    @PutMapping ("/pokemon")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon) throws Exception {
        return ResponseEntity.ok(pokemonService.updatePokemon(pokemon));
    }

    @DeleteMapping ("/pokemon/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.deletePokemonById(id));
    }

    @DeleteMapping("/pokemon/list")
    public ResponseEntity<String> deleteMultiplePokemons(@RequestBody List<Pokemon> pokemons) throws Exception {
        return ResponseEntity.ok(pokemonService.deleteMultiplePokemons(pokemons));
    }
}
