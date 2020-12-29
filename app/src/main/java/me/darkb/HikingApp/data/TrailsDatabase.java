package me.darkb.HikingApp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Trail.class}, version = 1)
@TypeConverters({ListConverter.class})
public abstract class TrailsDatabase extends RoomDatabase {
    private static TrailsDatabase INSTANCE;

    public abstract TrailDao trailDao();

    public synchronized static TrailsDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static TrailsDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context, TrailsDatabase.class, "trails")
//                .addCallback(new Callback(){
//                    @Override
//                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                        super.onCreate(db);
//                        Executors.newSingleThreadExecutor().execute(() -> getInstance(context).trailDao().insertAll(Trail.populateData()));
//                    }
//                })
//                .createFromAsset("database/trails.db")
//                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}
