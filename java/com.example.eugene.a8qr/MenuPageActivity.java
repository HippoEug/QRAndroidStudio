package com.example.eugene.a8qr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        // Attempt to launch an activity within own app
        Button scannerButton = (Button)findViewById(R.id.scannerButton);
        scannerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ScannerActivity.class);
                startActivity(startIntent); // Passing information to another activity
            }
        });

        // Attempt to launch an activity outside the app
        Button generatorButton = (Button)findViewById(R.id.generatorButton);
        generatorButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), GeneratorActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
