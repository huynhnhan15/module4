package com.codegym.songvalidate.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát tối đa 800 ký tự")
    @Pattern(regexp = "^[\\w\\s]+$", message = "Tên bài hát không được chứa ký tự đặc biệt")
    private String name;

    @NotBlank(message = "Ca sĩ không được để trống")
    @Size(max = 300, message = "Tên ca sĩ tối đa 300 ký tự")
    @Pattern(regexp = "^[\\w\\s]+$", message = "Tên ca sĩ không được chứa ký tự đặc biệt")
    private String artist;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Thể loại tối đa 1000 ký tự")
    @Pattern(regexp = "^[\\w\\s,]+$", message = "Thể loại chỉ được chứa chữ, số, dấu phẩy")
    private String genre;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}