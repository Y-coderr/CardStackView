import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yalantis.library.KolodaView;
import com.yalantis.library.interfaces.KolodaListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements KolodaListener {

    private KolodaView kolodaView;
    private CardAdapter adapter;
    private List<Profile> profiles;
    private Button skipButton;
    private Button likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupButtons();
    }

    private void setupViews() {
        kolodaView = findViewById(R.id.koloda_view);

        // Load profiles
        loadProfiles();

        // Set up adapter
        adapter = new CardAdapter(this, profiles);
        kolodaView.setAdapter(adapter);

        // Set up listener
        kolodaView.setKolodaListener(this);
    }

    private void setupButtons() {
        skipButton = findViewById(R.id.skip_button);
        likeButton = findViewById(R.id.like_button);

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kolodaView.onSwipeLeft();
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kolodaView.onSwipeRight();
            }
        });
    }

    private void loadProfiles() {
        profiles = new ArrayList<>();
        // Replace these with your own profile data and image resources
        profiles.add(new Profile("Emma Johnson", 28, "Travel enthusiast and coffee lover", R.drawable.profile1));
        profiles.add(new Profile("James Smith", 32, "Software engineer who loves hiking", R.drawable.profile2));
        profiles.add(new Profile("Olivia Davis", 24, "Photographer and adventure seeker", R.drawable.profile3));
        profiles.add(new Profile("Michael Wilson", 30, "Chef and fitness junkie", R.drawable.profile4));
        profiles.add(new Profile("Sophia Brown", 26, "Writer and book lover", R.drawable.profile5));
        // Add more profiles as needed
    }

    // KolodaListener implementation
    @Override
    public void onCardSwipedLeft(int position) {
        Toast.makeText(this, "Skipped " + profiles.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCardSwipedRight(int position) {
        Toast.makeText(this, "Liked " + profiles.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickRight(int position) {
        // Additional right action if needed
    }

    @Override
    public void onClickLeft(int position) {
        // Additional left action if needed
    }

    @Override
    public void onCardDoubleTap(int position) {
        // Handle double tap if needed
    }

    @Override
    public void onCardDrag(int position, @NonNull MotionEvent motionEvent) {
        // Handle card drag if needed
    }

    @Override
    public void onCardLongPress(int position) {
        // Handle long press if needed
    }

    @Override
    public void onEmptyDeck() {
        Toast.makeText(this, "No more profiles!", Toast.LENGTH_SHORT).show();
        // Optional: Reload profiles or show a message
    }
}