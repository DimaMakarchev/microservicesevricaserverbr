package com.ribbon.ribbon.model.onetoone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addres")
public class Addres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String addres;


    @OneToMany(mappedBy = "addres", fetch = FetchType.LAZY)
    private Set<Pioples> pioples;
}
