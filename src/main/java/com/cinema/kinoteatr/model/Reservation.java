package com.cinema.kinoteatr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "reservation",schema = "public")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reservation_id", nullable = false)
    private Long reservationId;

    @Column(name = "hall")
    private int hall;

    @Column(name = "row")
    private int row;

    @Column(name = "place")
    int place;



}
