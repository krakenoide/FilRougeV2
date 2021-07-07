package com.springmvc.testspringboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.testspringboot.modeles.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer>{

}
