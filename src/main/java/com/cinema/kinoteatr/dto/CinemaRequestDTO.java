package com.cinema.kinoteatr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaRequestDTO {
    Long id;
    String movie;
}
