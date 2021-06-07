package com.ribbon.ribbon.model.onetoone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String company;


    @OneToMany(mappedBy = "addres", fetch = FetchType.LAZY)
    private Set<Pioples> pioples;

    @ManyToMany(mappedBy = "companies")
    private Collection<Pioples> pioplescomp;
}
