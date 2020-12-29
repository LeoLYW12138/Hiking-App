package me.darkb.HikingApp.data;

import androidx.room.TypeConverter;

import java.util.Arrays;

public class ListConverter {
    @TypeConverter
    public static String[] fromString(String value) {
        return value.split(", ");
    }

    @TypeConverter
    public static String fromList(String[] list) {
        String s = Arrays.toString(list);
        return s.substring(1, s.length() - 1);
    }
}
