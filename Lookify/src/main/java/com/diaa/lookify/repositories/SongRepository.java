package com.diaa.lookify.repositories;

import com.diaa.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findAll();
    void deleteById(Long id);
    List<Song> findByArtistContaining(String search);
    List<Song> findTop10ByOrderByRatingDesc();
}
