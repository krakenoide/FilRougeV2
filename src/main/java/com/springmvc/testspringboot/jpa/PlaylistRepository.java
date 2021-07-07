package com.springmvc.testspringboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.testspringboot.modeles.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Integer>{

}
