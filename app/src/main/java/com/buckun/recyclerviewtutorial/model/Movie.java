package com.buckun.recyclerviewtutorial.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {


    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("like_percent")
    @Expose
    private int likePercent;

    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("is_new")
    @Expose
    private int isNewMovie;

    public Movie(int id, String image, String rating, int likePercent, int voteCount, String title, String language, String type, int isNewMovie) {
        Id = id;
        this.image = image;
        this.rating = rating;
        this.likePercent = likePercent;
        this.voteCount = voteCount;
        this.title = title;
        this.language = language;
        this.type = type;
        this.isNewMovie = isNewMovie;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLikePercent() {
        return likePercent;
    }

    public void setLikePercent(int likePercent) {
        this.likePercent = likePercent;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int isNewMovie() {
        return isNewMovie;
    }

    public void setNewMovie(int newMovie) {
        isNewMovie = newMovie;
    }
}
