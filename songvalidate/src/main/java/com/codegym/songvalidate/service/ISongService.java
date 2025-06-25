package com.codegym.songvalidate.service;


import com.codegym.songvalidate.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
}