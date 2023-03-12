package com.cinema.kinoteatr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema",schema = "public")
public class Cinema {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "movie_id", nullable = false)
    private Long id;

 //   @Id
 //   @SequenceGenerator(name = "cinema_seq",sequenceName = "cinema_cinema_id_seq",allocationSize = 0)
  //  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cinema_seq")
   // @Column(name = "movie_id",unique = true,nullable = false)
    //private Long movieId;

    @Column(name="movie_name")
    private String movie;

}
