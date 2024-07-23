package com.codegym.validate_thong_tin_bai_hat.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SongDTO {


    @NotEmpty(message = "Tên bài hát không được phép để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "Tên bài hát không chứa các ký tự đặc biệt như @ ; , . = - + ...")
    private String title;

    @NotEmpty(message = "Nghệ sĩ thể hiện không được phép để trống")
    @Size(max = 300, message = "Nghệ sĩ thể hiện không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "Nghệ sĩ thể hiện không chứa các ký tự đặc biệt như @ ; , . = - + ...")
    private String artist;

    @NotEmpty(message = "Thể loại nhạc không được phép để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Thể loại nhạc không chứa các ký tự đặc biệt ngoại trừ dấu phẩy ','")
    private String genre;

    public SongDTO() {
    }

    public SongDTO(String title, String genre, String artist) {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
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
