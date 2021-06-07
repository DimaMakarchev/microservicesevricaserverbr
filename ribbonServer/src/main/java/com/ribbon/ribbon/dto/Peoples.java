package com.ribbon.ribbon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peoples {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    private Adres adres;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_COMPANIES",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID"))
    private Collection<Many> manySet;

}
