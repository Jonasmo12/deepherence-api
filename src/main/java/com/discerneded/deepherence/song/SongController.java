package com.discerneded.deepherence.song;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public ResponseEntity<?> song() {
        return ResponseEntity.ok("New Song");
    }

    @PostMapping("/song/new")
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        return ResponseEntity.ok(songService.saveSong(song));
    }

    @GetMapping("/{songId}")
    public ResponseEntity<Song> playSong(@PathVariable("songId") Long songId) {
        return ResponseEntity.ok(songService.getSong(songId));
    }

    @GetMapping("/music/all")
    public List<Song> getMusic() {
        return songService.getSongs();
    }
}
