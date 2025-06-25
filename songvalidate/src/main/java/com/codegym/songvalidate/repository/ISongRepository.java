package com.codegym.songvalidate.repository;

import com.codegym.songvalidate.model.Song;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
}