package com.ribbon.ribbon.dto;

import com.google.inject.internal.cglib.core.$CodeGenerationException;
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
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameadress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adres")
    private Collection<Peoples> peoplesSet;
}
