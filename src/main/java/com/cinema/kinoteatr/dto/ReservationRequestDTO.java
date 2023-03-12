package com.cinema.kinoteatr.dto;

import com.cinema.kinoteatr.exception.ReservationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDTO {
    int hall;
    int row;
    int place;


}















