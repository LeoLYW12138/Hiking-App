package me.darkb.HikingApp.data;

import android.graphics.drawable.Drawable;

public class Trail {
    private Integer id;
    private Drawable img;
    private String title;
    private String subtitle;
    private Integer difficulty;
    private Float rating;

    Trail(Drawable trail_img, String trail_title, String trail_subtitle, Integer trail_difficulty, Float trail_rating){
        this.img = trail_img;
        this.title = trail_title;
        this.subtitle = trail_subtitle;
        this.difficulty = trail_difficulty;
        this.rating = trail_rating;
    }

    public Integer getId() {
        return id;
    }

    public Drawable getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public Float getRating() {
        return rating;
    }
}
