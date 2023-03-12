package com.cinema.kinoteatr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
