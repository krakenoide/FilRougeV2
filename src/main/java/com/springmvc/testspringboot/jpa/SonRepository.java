package com.springmvc.testspringboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.testspringboot.modeles.Son;

@Repository
public interface SonRepository extends JpaRepository<Son,Integer>{

}
