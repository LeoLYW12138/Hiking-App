package me.darkb.HikingApp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TrailDao {
    @Query("INSERT INTO trails (img, title, subtitle, difficulty, length, duration, region, start_pt, end_pt, isTarget) VALUES (:img, :title, :subtitle, :difficulty, :length, :duration, :region, :start, :end, :isTarget)")
    void create(Integer img, String title, String subtitle, Float difficulty, Float length, Float duration, String region, String start, String end, Boolean isTarget);

    @Insert
    void insertAll(Trail... trails);

    @Query("SELECT * FROM trails")
    List<Trail> getAll();

    @Query("SELECT * FROM trails WHERE isTarget")
    List<Trail> getAllTargets();

    @Query("SELECT * FROM trails WHERE id = :id")
    Trail getTrail(int id);

    @Query("UPDATE trails SET isTarget = :isTarget WHERE id = :id")
    void setTarget(Boolean isTarget, int id);
}
