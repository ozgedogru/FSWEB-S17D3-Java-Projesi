package com.workintech.sprint17d3.controller;

import com.workintech.sprint17d3.entity.Kangaroo;
import com.workintech.sprint17d3.entity.Koala;
import com.workintech.sprint17d3.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/koalas")
public class KoalaController {

    private final Map<Long, Koala> koalas = new HashMap<>();

    @GetMapping
    public Map<Long, Koala> getAllKoalas() {
        return koalas;
    }

    public ResponseEntity<Koala> getKoalaById(@PathVariable Long id) {
        if (!koalas.containsKey(id)) {
            throw new ResourceNotFoundException("Kangaroo does not exist with id: " + id);
        }
        Koala koala = koalas.get(id);
        return ResponseEntity.ok(koala);
    }

    @PostMapping
    public void addKoala(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
    }

    @PutMapping("/{id}")
    public void updateKoala(@PathVariable Long id, @RequestBody Koala koala) {
        koalas.put(id, koala);
    }

    @DeleteMapping("/{id}")
    public void deleteKoala(@PathVariable Long id) {
        koalas.remove(id);
    }
}