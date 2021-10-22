package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComicRepository extends JpaRepository<Comic, Integer> {

    @Query(value = "SELECT * FROM favorite_comics WHERE id_user = ?1", nativeQuery = true)
    public List<Comic> findByParentId(int id_user);

}