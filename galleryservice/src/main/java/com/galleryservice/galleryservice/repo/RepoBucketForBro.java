package com.galleryservice.galleryservice.repo;

import com.galleryservice.galleryservice.model.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoBucketForBro extends JpaRepository<Bucket,Integer> {
}
//@Repository
//public interface RepoBucketForBro extends ReactiveCrudRepository<Bucket,Integer> {
//}
