package com.cinema.dto;

import lombok.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
public class CinemaRequestDTO {
    @Min(value = 1,message = "Movie name wasnt be less 1")
    @Max(value = 20,message = "Movie name wasnt be more 20 characters")
    @NotEmpty(message = "Movie name wasnt be null")
   private String movie;
}
