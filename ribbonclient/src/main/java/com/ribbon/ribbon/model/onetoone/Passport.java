package com.ribbon.ribbon.model.onetoone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String namber;

    @OneToOne(optional = false,mappedBy = "passport")
    private Pioples pioples;
}
