package com.cinema.dto;

import lombok.*;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationRequestDTO {

    @Min(value = 1, message = "Hall wasnt be less 1")
    @Max(value = 5, message = "Hall wasnt be more 5")
    private int hall;

    @Min(value = 1, message = "Row wasnt be less 1")
    @Max(value = 12, message = "Row wasnt be more 12")
    private int row;

    @Min(value = 1, message = "Place wasnt be less 1")
    @Max(value = 10, message = "Place wasnt be more 10")
    private int place;


}















