package me.darkb.HikingApp.ui.trails;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import me.darkb.HikingApp.MainActivity;
import me.darkb.HikingApp.R;
import me.darkb.HikingApp.data.Trail;

public class TrailActivity extends AppCompatActivity {
    private Trail trail;
    private ImageView trailImage;
    private TextView trailTitle;
    private TextView trailSubtitle;
    private SimpleRatingBar trailDifficulty;
    private TextView trailLength;
    private TextView trailDuration;
    private TextView trailRegion;
    private TextView trailStart;
    private TextView trailEnd;
    private ImageButton flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);

//        trail = (Trail) getIntent().getSerializableExtra("trail");
        int id = getIntent().getIntExtra("id", 0);
        trail = MainActivity.database.trailDao().getTrail(id);

        trailImage = findViewById(R.id.view_img);
        trailTitle = findViewById(R.id.trail_title);
        trailSubtitle = findViewById(R.id.trail_subtitle);
        trailDifficulty = findViewById(R.id.trail_difficulty_data);
        trailLength = findViewById(R.id.trail_length_data);
        trailDuration = findViewById(R.id.trail_duration_data);
        trailRegion = findViewById(R.id.trail_region_data);
        trailStart = findViewById(R.id.start_details);
        trailEnd = findViewById(R.id.end_details);
        flag = findViewById(R.id.flag);
        loadData();
        flag.setOnClickListener(view -> {
            MainActivity.database.trailDao().setTarget(!trail.getTarget(), id);
            toggleFlag(!trail.getTarget());
        });
    }

    private void loadData() {
        trailImage.setImageResource(getResources().getIdentifier(trail.getImg(), "drawable", getPackageName()));
        trailTitle.setText(trail.getTitle());
        trailSubtitle.setText(trail.getSubtitle());
        trailDifficulty.setRating(trail.getDifficulty());
        trailLength.setText(trail.getLength() + " km");
        trailDuration.setText(trail.getDuration() + ((trail.getDuration() > 1.0f) ? " hours" : " hour"));
        trailRegion.setText(trail.getRegion());
        trailStart.setText(trail.getStart_pt());
        trailEnd.setText(trail.getEnd_pt());
        toggleFlag(trail.getTarget());
    }

    private void toggleFlag(boolean isTarget) {
        if (isTarget) {
            flag.setImageResource(R.drawable.ic_round_flag_24);
        } else {
            flag.setImageResource(R.drawable.ic_round_outlined_flag_24);
        }
    }
}
