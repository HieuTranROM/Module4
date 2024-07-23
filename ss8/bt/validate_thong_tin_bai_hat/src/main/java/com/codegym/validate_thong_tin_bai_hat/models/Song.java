package com.codegym.validate_thong_tin_bai_hat.models;


import jakarta.persistence.*;

@Entity(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Long id;

    @Column(name = "title", columnDefinition = "LONGTEXT")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "genre", columnDefinition = "LONGTEXT")
    private String genre;

    public Song() {
    }

    public Song(Long id, String title, String artist, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
