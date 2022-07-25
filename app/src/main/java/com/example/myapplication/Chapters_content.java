package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class Chapters_content extends AppCompatActivity
       {


    TextToSpeech tts;
    ImageButton voice;
    TextView textview;
    TextView chapters_content_textview;
    DatabaseHelper dbhelper;
    int text_size;
    EditText e1;
    String content;
    String first;
    FloatingActionButton back,forward;
    String child;
    String parent;
    int child_index;
    int parent_index;
    String chapter_child_name;
    String chapter_parent_name;
    MediaPlayer mediaPlayer;
           String s;


//    public Chapters_content (float text_size){
//        this.text_size=text_size;
//    }
   // final String[] chapters=new String[200];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapters_content);

        dbhelper=new DatabaseHelper(this);
        textview=findViewById(R.id.chapters_content);
        back=findViewById(R.id.back);
        mediaPlayer=new MediaPlayer();
        forward=findViewById(R.id.forward);
        chapters_content_textview=findViewById(R.id.chapters_content_textview);

        tts=new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            public void onInit(int i){
                if(i==TextToSpeech.SUCCESS){
                    int lang=tts.setLanguage(Locale.US);
                }
            }
        });
        ImageButton nav=findViewById(R.id.s);
        voice=findViewById(R.id.voice);
        e1=findViewById(R.id.e1);
        e1.setVisibility(View.GONE);
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Chapters_content.this, "VOICE", Toast.LENGTH_SHORT).show();
                s=textview.getText().toString();
                int speech=tts.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                //speakOut();
            }
        });

        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tts!=null){
                    tts.stop();
                    //tts.shutdown();
                }
                Intent intent=new Intent(Chapters_content.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(Chapters_content.this, "BACK", Toast.LENGTH_SHORT).show();
            }
        });
        MainActivity m=new MainActivity();
//        m.expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int i, int i1, long l) {

        //child=m.selected;
                //Toast.makeText(Chapters_content.this, "SELECTED IS: "+child, Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });



        Bundle b=getIntent().getExtras();
        first=b.getString("chapter_1");
        e1.setText(first);
        child=b.getString("child_name");
        parent=b.getString("parent_name");
        child_index=b.getInt("child_index");
        parent_index=b.getInt("parent_index");
       // chapter_child_name=b.getString("chapter_child_name");
        chapter_parent_name=b.getString("chapter_parent_name");
        chapters_content_textview.setText(chapter_parent_name+" "+getString(R.string.chapter)+(child_index+1));

        final String[] chapters2=b.getStringArray("chapters_content");
        if(child_index==0){
            back.setVisibility(View.GONE);
        }
        if(child_index==(chapters2.length-1)){
            forward.setVisibility(View.GONE);
        }

        //final String[] chapters=b.getStringArray("chapters_content");
//        if(parent_index==0){
//            final String[] chapters=getResources().getStringArray(R.array.matthew_chapters);
//        }
//        else if(parent_index==1){
//            final String[] chapters=getResources().getStringArray(R.array.Mark_chapters);
//        }
//       content=getIntent().getStringExtra("");
        Cursor c =dbhelper.Read_sizs();
        //Cursor c=dbhelper.ViewStudentInfo();
        int x=c.getCount();

       // StringBuffer buffer = new StringBuffer();

        while(c.moveToNext()){
            //buffer.append("NAME: " + c.getString(0) + "\n");
            //buffer.append("PASSWORD :" + c.getString(1)+"\n");
            //buffer.append("DEPARTMENT :" + cursor.getString(2)+"\n\n");
            text_size=c.getInt(1);
        }
        if(text_size>0){
            textview.setTextSize(text_size);
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        }
        else{
            textview.setTextSize(25);
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }
        textview.setText(first);


//        textview.setTextSize(12);
        //set_textsize();
        //set_textsize(text_size);

        //textview.setTextSize(text_size);
        Toast.makeText(Chapters_content.this, "SELECTED IS: "+child+" "+child_index+" "+parent+" "+parent_index, Toast.LENGTH_SHORT).show();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tts!=null){
                    tts.stop();
                    //tts.shutdown();
                }
//                tts.stop();
//                boolean speak=tts.isSpeaking();
//                if(speak==true){
//                    tts.stop();
//                }
                final String[] chapters=b.getStringArray("chapters_content");
                Toast.makeText(Chapters_content.this, "BACK BUTTON IS PRESSED ", Toast.LENGTH_LONG).show();
                String content2=chapters[child_index-1];
                s=content2;

                if(child_index>=0){
                    forward.setVisibility(View.VISIBLE);
                }

                    child_index = child_index - 1;
                chapters_content_textview.setText(chapter_parent_name+" "+getString(R.string.chapter)+(child_index+1));
                textview.setText(content2);

                if(child_index-1<0){
                    back.setVisibility(View.GONE);
                }
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tts!=null){
                    tts.stop();
                    //tts.shutdown();
                }
                final String[] chapters=b.getStringArray("chapters_content");
                String content2=chapters[child_index+1];
                if(child_index>=0){
                    back.setVisibility(View.VISIBLE);
                }
//                if((child_index+1)==chapters.length){
//                    forward.setVisibility(View.GONE);
//                }
                child_index=child_index+1;
                chapters_content_textview.setText(chapter_parent_name+" "+getString(R.string.chapter)+(child_index+1));
                textview.setText(content2);
                if(child_index>=(chapters.length-1)){
                    forward.setVisibility(View.GONE);
                }
                Toast.makeText(Chapters_content.this, "FORWARD BUTTON IS PRESSED", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onDestroy() {
// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
//
//    @Override
//    public void onInit(int status) {
//
//        if (status == TextToSpeech.SUCCESS) {
//
//            int result = tts.setLanguage(Locale.US);
//
//            if (result == TextToSpeech.LANG_MISSING_DATA
//                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                Log.e("TTS", "This Language is not supported");
//                Toast.makeText(this, "THIS LANGUAGE IS NOT SUPPORTED", Toast.LENGTH_SHORT).show();
//            } else {
//                voice.setEnabled(true);
//                speakOut();
//            }
//
//        } else {
//            Log.e("TTS", "Initilization Failed!");
//            Toast.makeText(this, "INITIALIZATION FAILED", Toast.LENGTH_SHORT).show();
//        }
//
//    }

    private void speakOut() {
        //String text = textview.getText().toString();
//        Bundle b=getIntent().getExtras();
//        first=b.getString("chapter_1");
//        Log.e("",first);
  //first="FUCK YOU";
//        Log.e("",first);

        first=e1.getText().toString();
        tts.speak(first, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void set_textsize(float size){
        textview.setTextSize(size);
    }

           public void stop() {
               if (tts != null) {
                   if (tts.isSpeaking()) {
                       tts.stop();
                   }
                   tts.shutdown();
               }
               if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                   mediaPlayer.stop();
                   mediaPlayer.release();
                   mediaPlayer = null;
                   //mediaHandler.removeCallbacks(mHighlightTask);
               }
           }

}