package com.cinema.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "session",schema = "public")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "session_id", nullable = false)
    private Long sessionId;

    @Column(name = "session_date",nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Cinema cinema;


}
