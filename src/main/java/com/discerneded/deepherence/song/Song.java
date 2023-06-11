package com.discerneded.deepherence.song;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Song")
@Getter
@Setter
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate releaseDate;
    private String artist;
    private String url;

    public Song(
            String name,
            LocalDate releaseDate,
            String artist,
            String url
    ) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.url = url;
    }
}
