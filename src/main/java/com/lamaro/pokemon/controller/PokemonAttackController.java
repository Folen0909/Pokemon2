package com.lamaro.pokemon.controller;

import com.lamaro.pokemon.model.PokemonAttack;
import com.lamaro.pokemon.services.PokemonAttackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class PokemonAttackController {

    private final PokemonAttackService pokemonAttackService;

    public PokemonAttackController(PokemonAttackService pokemonAttackService) {
        this.pokemonAttackService = pokemonAttackService;
    }

    @PostMapping("/pokemonAttack/new")
    public ResponseEntity<PokemonAttack> createPokemonAttack(@RequestBody PokemonAttack pokemonAttack) {
        return ResponseEntity.ok(pokemonAttackService.createPokemonAttack(pokemonAttack));
    }

    @GetMapping("/pokemonAttack/{id}")
    public ResponseEntity<PokemonAttack> showPokemonAttackById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(pokemonAttackService.findPokemonAttackById(id));
    }

    @GetMapping("/pokemonAttack")
    public ResponseEntity<Page<PokemonAttack>> showAllAttacks(Pageable pageable) {
        return ResponseEntity.ok(pokemonAttackService.findAllAttacks(pageable));
    }

    @PutMapping("/pokemonAttack")
    public ResponseEntity<PokemonAttack> updatePokemonAttack(@RequestBody PokemonAttack pokemonAttack) throws Exception {
        return ResponseEntity.ok(pokemonAttackService.updatePokemonAttack(pokemonAttack));
    }

    @DeleteMapping("/pokemonAttack/{id}")
    public ResponseEntity<String> deletePokemonAttacksById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonAttackService.deletePokemonAttacksById(id));
    }

}
