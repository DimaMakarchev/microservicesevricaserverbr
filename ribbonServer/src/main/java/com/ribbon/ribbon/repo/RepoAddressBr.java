package com.ribbon.ribbon.repo;

import com.ribbon.ribbon.dto.Adres;
import com.ribbon.ribbon.dto.Peoples;
import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAddressBr extends JpaRepository<Adres, Integer> {
}
