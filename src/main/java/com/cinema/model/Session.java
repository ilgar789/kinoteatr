package com.cinema.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Table(name = "session",schema = "public")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", nullable = false)
    private Long Id;

    @Column(name = "session_date",nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Cinema cinema;



}