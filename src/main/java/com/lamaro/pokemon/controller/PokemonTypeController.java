package com.lamaro.pokemon.controller;

import com.lamaro.pokemon.model.PokemonType;
import com.lamaro.pokemon.services.PokemonTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class PokemonTypeController {

    private final PokemonTypeService pokemonTypeService;


    public PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @PostMapping("/pokemonType/new")
    public ResponseEntity<PokemonType> createPokemonType(@RequestBody PokemonType pokemonType) {
        return ResponseEntity.ok(pokemonTypeService.createPokemonType(pokemonType));
    }

    @GetMapping("/pokemonType/{id}")
    public ResponseEntity<PokemonType> showPokemonTypeById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(pokemonTypeService.findPokemonTypeById(id));
    }

    @GetMapping("/pokemonType")
    public ResponseEntity<Page<PokemonType>> showPokemonTypeAll(@PageableDefault(size = 20)  Pageable pageable) {
        return ResponseEntity.ok(pokemonTypeService.findAllPokemonTypes(pageable));
    }

    @PutMapping("/pokemonType")
    public ResponseEntity<PokemonType> updatePokemonType(@RequestBody PokemonType pokemonType) throws Exception {
        return ResponseEntity.ok((pokemonTypeService.updatePokemonType(pokemonType)));
    }

    @DeleteMapping("/pokemonType/{id}")
    public ResponseEntity<String> deletePokemonType(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonTypeService.deletePokemonTypeById(id));
    }

}
