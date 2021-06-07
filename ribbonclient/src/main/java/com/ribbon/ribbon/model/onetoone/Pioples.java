package com.ribbon.ribbon.model.onetoone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pioples")
public class Pioples {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "addres_id")
    private Addres addres;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "PERSON_COMPANIES",
                joinColumns = @JoinColumn(name = "PERSON_ID"),
                inverseJoinColumns = @JoinColumn(name = "COMPANY_ID"))
    private Collection<Company> companies;
    //@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //    @JoinTable(name = "PERSON_COMPANIES",
    //            joinColumns = @JoinColumn(name = "PERSON_ID"),
    //            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID"))
}
