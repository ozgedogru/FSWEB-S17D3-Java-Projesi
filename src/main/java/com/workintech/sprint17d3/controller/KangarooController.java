package com.workintech.sprint17d3.controller;

import com.workintech.sprint17d3.entity.Kangaroo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/kangaroos")
public class KangarooController {

    private final Map<Long, Kangaroo> kangaroos = new HashMap<>();

    @GetMapping
    public Map<Long, Kangaroo> getAllKangaroos() {
        return kangaroos;
    }

    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable Long id) {
        return kangaroos.get(id);
    }

    @PostMapping
    public void addKangaroo(@RequestBody Kangaroo kangaroo) {
        kangaroos.put(kangaroo.getId(), kangaroo);
    }

    @PutMapping("/{id}")
    public void updateKangaroo(@PathVariable Long id, @RequestBody Kangaroo kangaroo) {
        kangaroos.put(id, kangaroo);
    }

    @DeleteMapping("/{id}")
    public void deleteKangaroo(@PathVariable Long id) {
        kangaroos.remove(id);
    }
}