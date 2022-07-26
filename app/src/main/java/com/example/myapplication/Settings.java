package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Settings extends AppCompatActivity {
    Button setting,help,about,font,fav;
    TextView setting_text_view;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        setting=findViewById(R.id.lang);
        help=findViewById(R.id.help);
        about=findViewById(R.id.about);
        font=findViewById(R.id.font);
        fav=findViewById(R.id.fav);
        setting_text_view=findViewById(R.id.setting_textview);
        setting_text_view.setText(getString(R.string.setting_textview));

        ImageButton back =findViewById(R.id.s);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChangeLanguageDialog();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(Settings.this, "HELP", Toast.LENGTH_SHORT).show();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Settings.this, "ABOUT", Toast.LENGTH_SHORT).show();
            }
        });
        font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Settings.this, "FONT", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Settings.this,change_font_size.class);
                startActivity(intent);
            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Settings.this, "Favourite", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Settings.this,Favourite_contents.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Settings.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(Settings.this, "BACK", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showChangeLanguageDialog() {

        final String[]listitems ={"English","አማርኛ"};
        AlertDialog.Builder mbuilder=new AlertDialog.Builder(Settings.this);
        mbuilder.setTitle("Choose language");
        mbuilder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(which ==0){
                    setLocale("en");
                    recreate();
                }
                else if(which == 1){
                    setLocale("am");
                    recreate();
                }
                dialog.dismiss();

            }
        });
        AlertDialog  mDialog=mbuilder.create();
        mDialog.show();
    }
    private void setLocale(String lang) {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration congig=new Configuration();
        congig.locale=locale;
        getBaseContext().getResources().updateConfiguration(congig,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My language",lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences preferences=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=preferences.getString("My language","");
        setLocale(language);
    }
}
