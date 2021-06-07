package com.ribbon.ribbon.repo;

import com.ribbon.ribbon.dto.Adres;
import com.ribbon.ribbon.dto.Many;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoManyBr extends JpaRepository<Many, Integer> {
}
