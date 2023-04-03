package com.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CinemaRequestDTO {
    Long id;
    @Min(value = 1,message = "Movie name wasnt be less 1")
    @Max(value = 20,message = "Movie name wasnt be more 20 characters")
    @NotEmpty(message = "Movie name wasnt be null")
    String movie;
}
