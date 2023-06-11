package com.discerneded.deepherence.song;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

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
}
