package com.example.cardstackview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityAlternative extends AppCompatActivity {

    private SwipeFlingAdapterView swipeFlingAdapterView;
    private CardAdapter adapter;
    private List<Profile> profiles;
    private Button skipButton;
    private Button likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alternative);

        setupViews();
        setupButtons();
    }

    private void setupViews() {
        swipeFlingAdapterView = findViewById(R.id.swipe_view);

        // Load profiles
        loadProfiles();

        // Set up adapter
        adapter = new CardAdapter(this, profiles);
        swipeFlingAdapterView.setAdapter(adapter);

        // Set up listener
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                if (!profiles.isEmpty()) {
                    profiles.remove(0);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                Profile profile = (Profile) dataObject;
                Toast.makeText(MainActivityAlternative.this, "Skipped " + profile.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Profile profile = (Profile) dataObject;
                Toast.makeText(MainActivityAlternative.this, "Liked " + profile.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                if (itemsInAdapter == 0) {
                    Toast.makeText(MainActivityAlternative.this, "No more profiles!", Toast.LENGTH_SHORT).show();
                    // Optional: Reload profiles
                    // loadProfiles();
                    // adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                // Optional: Implement visual feedback during scrolling
            }
        });
    }

    private void setupButtons() {
        skipButton = findViewById(R.id.skip_button_alt);
        likeButton = findViewById(R.id.like_button_alt);

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeFlingAdapterView.getTopCardListener().selectLeft();
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeFlingAdapterView.getTopCardListener().selectRight();
            }
        });
    }

    private void loadProfiles() {
        profiles = new ArrayList<>();
        // Using Android's default drawables or drawables that already exist in your project
        // Replace these with drawables that actually exist in your project
        profiles.add(new Profile("Emma Johnson", 28, "Travel enthusiast and coffee lover", android.R.drawable.ic_menu_gallery));
        profiles.add(new Profile("James Smith", 32, "Software engineer who loves hiking", android.R.drawable.ic_menu_camera));
        profiles.add(new Profile("Olivia Davis", 24, "Photographer and adventure seeker", android.R.drawable.ic_menu_myplaces));
        profiles.add(new Profile("Michael Wilson", 30, "Chef and fitness junkie", android.R.drawable.ic_menu_compass));
        profiles.add(new Profile("Sophia Brown", 26, "Writer and book lover", android.R.drawable.ic_menu_agenda));
        // Add more profiles as needed
    }
}