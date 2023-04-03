package com.cinema.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema",schema = "public")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Long id;

    @Column(name="movie_name")
    private String movie;



}
