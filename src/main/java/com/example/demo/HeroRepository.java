package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Integer> {

    @Query(value = "SELECT * FROM favorite_heroes WHERE id_user = ?1", nativeQuery = true)
    public List<Hero> findByParentId(int id_user);

}