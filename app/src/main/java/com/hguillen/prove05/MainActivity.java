package com.hguillen.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_BOOK_NAME = "book";
    private static final String EXTRA_CHAPTER_NAME = "chapter";
    private static final String EXTRA_VERSE_NAME = "verse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText = findViewById(R.id.editTextBook);
        String book = editText.getText().toString();
        editText = findViewById(R.id.editTextChapter);
        String chapter = editText.getText().toString();
        editText = findViewById(R.id.editTextVerse);
        String verse = editText.getText().toString();

        String message = "About to create intent with " + book + " " + " " + chapter + " " + verse;
        Log.d("Intent Creation ", message);

        intent.putExtra(EXTRA_BOOK_NAME, book);
        intent.putExtra(EXTRA_CHAPTER_NAME, chapter);
        intent.putExtra(EXTRA_VERSE_NAME, verse);
        startActivity(intent);
    }

    public void loadFile(View view) {
        SharedPreferences sharedPref = getSharedPreferences("Scripture", Context.MODE_PRIVATE);
        // SharedPreferences.Editor editor = sharedPref.edit();
        String book = sharedPref.getString(EXTRA_BOOK_NAME, "book");
        String chapter = sharedPref.getString(EXTRA_CHAPTER_NAME, "chapter");
        String verse = sharedPref.getString(EXTRA_VERSE_NAME, "verse");

        EditText editBook = findViewById(R.id.editTextBook);
        EditText editChapter = findViewById(R.id.editTextChapter);
        EditText editVerse = findViewById(R.id.editTextVerse);

        editBook.setText(book);
        editChapter.setText(chapter);
        editVerse.setText(verse);
    }
}