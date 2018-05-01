package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mike.fantasygame.R;

public class MainScreen extends AppCompatActivity {

    private EditText userNameEditText;
    private Button beginAdventureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        userNameEditText = findViewById(R.id.userNameEditTextId);
        beginAdventureButton = findViewById(R.id.beginAdventureButtonId);
    }

    public void onBeginAdventureButtonClicked(View button){
        String userName = userNameEditText.getText().toString();
        Intent intent = new Intent(this, DifficultyActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }
}
