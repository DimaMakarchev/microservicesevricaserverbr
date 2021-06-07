package com.ribbon.ribbon.repo;

import com.ribbon.ribbon.model.onetoone.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPassport extends JpaRepository<Passport, Integer> {
}
