package com.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDTO {

    @Min(value = 1,message = "Hall wasnt be less 1")
    @Max(value = 5,message = "Hall wasnt be more 5")
    int hall;

    @Min(value = 1,message = "Row wasnt be less 1")
    @Max(value = 12,message = "Row wasnt be more 12")
    int row;

    @Min(value = 1,message = "Place wasnt be less 1")
    @Max(value = 10,message = "Place wasnt be more 10")
    int place;


}















