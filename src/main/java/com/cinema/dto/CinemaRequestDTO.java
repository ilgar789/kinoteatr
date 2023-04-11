package com.cinema.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
public class CinemaRequestDTO {

    @Size(max = 20,message = "Movie name wasnt be more 20 characters")
    @NotEmpty(message = "Movie name wasnt be null")
    private String movie;
}
