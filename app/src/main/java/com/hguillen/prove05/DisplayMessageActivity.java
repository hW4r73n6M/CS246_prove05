package com.hguillen.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String EXTRA_BOOK_NAME = "book";
    private static final String EXTRA_CHAPTER_NAME = "chapter";
    private static final String EXTRA_VERSE_NAME = "verse";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        if (intent != null) {
            String book = intent.getStringExtra("book");
            String chapter = intent.getStringExtra("chapter");
            String verse = intent.getStringExtra("verse");
            String message = "Received intent with " + book + " " + chapter + ":" + verse;

            Log.d("Intent Received ", message);

            // Capture the layout's TextView and set the string as its text
            TextView textView = findViewById(R.id.textView);
            textView.setText(book + " " + chapter + ":" + verse);
        } else {
            TextView textView = findViewById(R.id.textView);
            textView.setText("Oh, don't you have a favorite scripture? Try Ether 12:27");
        }
    }

    public void savefile(View view) {
        Intent intent = getIntent();

        SharedPreferences sharedPref = this.getSharedPreferences("Scripture", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(EXTRA_BOOK_NAME, intent.getStringExtra("book"));
        editor.putString(EXTRA_CHAPTER_NAME, intent.getStringExtra("chapter"));
        editor.putString(EXTRA_VERSE_NAME, intent.getStringExtra("verse"));
        editor.apply();

        Toast toast = Toast.makeText(getApplicationContext(), "Scripture saved successfully", Toast.LENGTH_SHORT);
            toast.show();
        returnMain(view);
    }
        public void returnMain(View View){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
}