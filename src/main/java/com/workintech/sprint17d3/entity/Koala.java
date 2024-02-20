package com.workintech.sprint17d3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Koala {
    private Long id;
    private String name;
    private double weight;
    private int sleepHour;
    private String gender;

}
