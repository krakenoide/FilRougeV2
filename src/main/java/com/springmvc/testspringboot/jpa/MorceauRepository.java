package com.springmvc.testspringboot.jpa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.testspringboot.modeles.Morceau;


public interface MorceauRepository extends JpaRepository<Morceau,Integer>{

}
