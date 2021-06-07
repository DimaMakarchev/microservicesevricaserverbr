package com.ribbon.ribbon.repo;

import com.ribbon.ribbon.model.onetoone.Passport;
import com.ribbon.ribbon.model.onetoone.Pioples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPiople extends JpaRepository<Pioples, Integer> {
}
