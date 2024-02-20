package com.workintech.sprint17d3.controller;

import com.workintech.sprint17d3.entity.Kangaroo;
import com.workintech.sprint17d3.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Kangaroo> getKangarooById(@PathVariable Long id) {
        if (!kangaroos.containsKey(id)) {
            throw new ResourceNotFoundException("Kangaroo does not exist with id: " + id);
        }
        Kangaroo kangaroo = kangaroos.get(id);
        return ResponseEntity.ok(kangaroo);
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