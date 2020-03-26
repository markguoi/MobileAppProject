package fr.mark.mobileappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView songContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        songContent = findViewById(R.id.contentOfSong);
        Intent i = getIntent();
        String title = i.getStringExtra("titleOfSong");
        String content = i.getStringExtra("contentOfSong");
        final String link = i.getStringExtra("linkOfSong");

        //set the appbar title as Song title
        getSupportActionBar().setTitle(title);

        //set content of the story to textview
        songContent.setText(content);
        songContent.setMovementMethod(new ScrollingMovementMethod());

        // enable back button to main activity or recyclerview
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Youtube.class);
                intent.putExtra("link", link);
                startActivity(intent);

            }
        });
    }
}
