package com.cinema.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema",schema = "public")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "movie_id", nullable = false)
    private Long id;

    @Column(name="movie_name")
    private String movie;

}
