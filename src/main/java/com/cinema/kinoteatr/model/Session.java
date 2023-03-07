package com.cinema.kinoteatr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "session",schema = "public")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "s_id", nullable = false)
    private Long id;

    @Column(name = "sens",nullable = false)
    private Date date;

}
