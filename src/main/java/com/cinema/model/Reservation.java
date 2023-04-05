package com.cinema.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "reservation",schema = "public")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Long id;

    @Column(name = "hall")
    private int hall;

    @Column(name = "row")
    private int row;

    @Column(name = "place")
    private int place;

    @ManyToOne
    @JoinColumn(name="session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
