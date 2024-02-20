package com.workintech.sprint17d3.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {


    private String message;

}
