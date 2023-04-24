package com.example.debuggingwebprog.Model;

public class Movie {
    private String title;
    private String genre;
    private String year;
    private String director;

    public Movie(String title, String genre, String year, String director) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.director = director;
    }
    // Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}
