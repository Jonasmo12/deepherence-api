package com.discerneded.deepherence.song;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song saveSong(Song song) {
        return songRepository.save(
                new Song(
                        song.getName(),
                        song.getReleaseDate(),
                        song.getArtist(),
                        song.getUrl()
                )
        );
    }

    public Song getSong(Long songId) {
        return songRepository.findById(songId)
                .orElseThrow(() -> new IllegalStateException("Song not found"));
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }
}
