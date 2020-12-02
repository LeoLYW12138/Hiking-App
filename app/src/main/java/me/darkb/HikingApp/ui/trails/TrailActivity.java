package me.darkb.HikingApp.ui.trails;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.darkb.HikingApp.R;
import me.darkb.HikingApp.data.Trail;

public class TrailActivity extends AppCompatActivity {
    private Trail trail;
    private ImageView trailImage;
    private TextView trailTitle;
    private TextView trailSubtitle;
    private RatingBar trailDifficulty;
    private TextView trailLength;
    private TextView trailDuration;
    private TextView trailRegion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);

        trail = (Trail) getIntent().getSerializableExtra("trail");

        trailImage = findViewById(R.id.view_img);
        trailTitle = findViewById(R.id.trail_title);
        trailSubtitle = findViewById(R.id.trail_subtitle);
        trailDifficulty = findViewById(R.id.trail_rating);
        trailLength = findViewById(R.id.trail_length_data);
        trailDuration = findViewById(R.id.trail_duration_data);
        trailRegion = findViewById(R.id.trail_region_data);

        loadData();
    }

    public void loadData() {
        trailImage.setImageResource(trail.getImg());
        trailTitle.setText(trail.getTitle());
        trailSubtitle.setText(trail.getSubtitle());
        trailDifficulty.setRating(trail.getDifficulty());
        trailLength.setText(String.valueOf(trail.getLength()));
        trailDuration.setText(String.valueOf(trail.getDuration()));
        trailRegion.setText(trail.getRegion());

    }
}
