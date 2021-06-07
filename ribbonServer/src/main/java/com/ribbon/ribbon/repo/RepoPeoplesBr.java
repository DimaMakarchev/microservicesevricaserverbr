package com.ribbon.ribbon.repo;

import com.ribbon.ribbon.dto.Peoples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPeoplesBr extends JpaRepository<Peoples, Integer> {
}
