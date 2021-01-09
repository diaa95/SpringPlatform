package com.diaa.lookify.services;


import com.diaa.lookify.models.Song;
import com.diaa.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public List<Song> search(String artist){
        return songRepository.findByArtistContaining(artist);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public List<Song> topTen(){
        return songRepository.findTop10ByOrderByRatingDesc();
    }


}
