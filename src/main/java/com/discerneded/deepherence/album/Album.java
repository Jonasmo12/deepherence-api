package com.discerneded.deepherence.album;

import com.discerneded.deepherence.song.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String artists;
    private LocalDate releaseDate;
    private LocalDate uploadDate = LocalDate.now();
    private String genre;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "album_id",
            referencedColumnName = "id"
    )
    private Set<Song> songs = new HashSet<>();
}
