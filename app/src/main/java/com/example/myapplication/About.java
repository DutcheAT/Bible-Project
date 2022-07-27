package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    Button Btn1,Btn2,Btn3,Btn4,Btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Btn1=findViewById(R.id.button1);
        Btn2=findViewById(R.id.button2);
        Btn3=findViewById(R.id.button3);
        Btn4=findViewById(R.id.button4);
        Btn5=findViewById(R.id.button5);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pass filter in this intent
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/amani387"));
                startActivity(intent);
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pass filter in this intent
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Han-nahh"));
                startActivity(intent);
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pass filter in this intent
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Eyuel369"));
                startActivity(intent);
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pass filter in this intent
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/DutcheAT"));
                startActivity(intent);
            }
        });


        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pass filter in this intent
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/BetsegawLire"));
                startActivity(intent);
            }
        });
    }
}