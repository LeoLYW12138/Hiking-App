package me.darkb.HikingApp.data;

import java.io.Serializable;

public class Trail implements Serializable {
    private Integer img;
    private String title;
    private String subtitle;
    private Float difficulty;
    private Integer rating;
    private Float length;
    private Float duration;
    private String region;

    public Trail(Integer trail_img, String trail_title, String trail_subtitle, Float trail_difficulty,
                 Integer trail_rating, Float length, Float duration, String region) {
        this.img = trail_img;
        this.title = trail_title;
        this.subtitle = trail_subtitle;
        this.difficulty = trail_difficulty;
        this.rating = trail_rating;
        this.length = length;
        this.duration = duration;
        this.region = region;
    }

    public Integer getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Float getDifficulty() {
        return difficulty;
    }

    public Integer getRating() {
        return rating;
    }

    public Float getLength() {
        return length;
    }

    public Float getDuration() {
        return duration;
    }

    public String getRegion() {
        return region;
    }
}
