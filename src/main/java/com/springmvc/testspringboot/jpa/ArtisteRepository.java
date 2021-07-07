package com.springmvc.testspringboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.testspringboot.modeles.Artiste;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste,Integer>{

}
