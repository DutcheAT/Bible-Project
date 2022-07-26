package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class change_font_size extends AppCompatActivity {

    SeekBar sk;
    TextView tv;
    ImageButton back;

    DatabaseHelper dbhelper;
    int seekValue;
    Settings setting;
    Chapters_content chapters_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_font_size);

        sk=findViewById(R.id.seekBar);
        tv=findViewById(R.id.textView);
        dbhelper=new DatabaseHelper(this);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(change_font_size.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //ed=findViewById(R.id.edittext);
      setting=new Settings();

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //tv.setText(ed.getText().toString());
                tv.setTextSize(seekValue);

                //dbhelper.insert_font_size();
//                boolean b1=dbhelper.insert_font_size();
//                if (b1==true){
//                    Toast.makeText(change_font_size.this, "success", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(change_font_size.this, "failed", Toast.LENGTH_SHORT).show();
//                }
                boolean b=dbhelper.updateStudentInfo(seekValue);
                if (b==true){
                    Toast.makeText(change_font_size.this, "success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(change_font_size.this, "failed", Toast.LENGTH_SHORT).show();
                }
                //chapters_content.textview.setTextSize(seekValue);
               // chapters_content=new Chapters_content(seekValue);
                //chapters_content.set_textsize(seekValue);
            }
        });
    }

}