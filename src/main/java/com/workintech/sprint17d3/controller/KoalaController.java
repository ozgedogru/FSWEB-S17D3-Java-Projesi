package com.workintech.sprint17d3.controller;

import com.workintech.sprint17d3.entity.Kangaroo;
import com.workintech.sprint17d3.entity.Koala;
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

    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable Long id) {
        return koalas.get(id);
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