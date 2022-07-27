package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.myapplication.Model.Books;
import com.example.myapplication.Model.Chapter;
import com.example.myapplication.adapter.Custom_adapter1;

import java.util.ArrayList;
import java.util.List;

public class OldCovenant extends Fragment {
    ExpandableListView expandableListView;
    Custom_adapter1 customadapter;
    List<Books> BookList;
    List<Chapter> ChapterList;
    long group_num;
    long chapter_num;
    long selected;
    long parent_name;
    String chapter_parent_name;

    ExpandableListAdapter expandableListAdapter;


    public OldCovenant(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.old_covenant,container,false);


    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        expandableListView=(ExpandableListView) view.findViewById(R.id.expandablelistView);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition =-1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition !=-1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition =groupPosition;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View v, int groupPosition, int childPosition, long id) {
                selected= customadapter.getChildId(groupPosition,childPosition);
                parent_name= customadapter.getGroupId(groupPosition);

                if(parent_name==0){
                    final String[] chapters=getResources().getStringArray(R.array.Genesis_chapters);
                    chapter_parent_name=getString(R.string.genesis);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==1){
                    final String[] chapters=getResources().getStringArray(R.array.Exodus_chapters);
                    chapter_parent_name=getString(R.string.exodus);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==2){
                    final String[] chapters=getResources().getStringArray(R.array.Leviticus_chapters);
                    chapter_parent_name=getString(R.string.leviticus);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==3){
                    final String[] chapters=getResources().getStringArray(R.array.Numbers_chapters);
                    chapter_parent_name=getString(R.string.numbers);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==4){
                    final String[] chapters=getResources().getStringArray(R.array.Dueteronomy_chapters);
                    chapter_parent_name=getString(R.string.deuteronomy);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==5){
                    final String[] chapters=getResources().getStringArray(R.array.Joshua_chapters);
                    chapter_parent_name=getString(R.string.joshua);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==6){
                    final String[] chapters=getResources().getStringArray(R.array.Judges_chapters);
                    chapter_parent_name=getString(R.string.judges);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                if(parent_name==7){
                    final String[] chapters=getResources().getStringArray(R.array.Ruth_chapters);
                    chapter_parent_name=getString(R.string.ruth);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==8){
                    final String[] chapters=getResources().getStringArray(R.array.Samuel1_chapters);
                    chapter_parent_name=getString(R.string.samuel1);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==9){
                    final String[] chapters=getResources().getStringArray(R.array.Samuel2_chapters);
                    chapter_parent_name=getString(R.string.samuel2);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==10){
                    final String[] chapters=getResources().getStringArray(R.array.Kings1_chapters);
                    chapter_parent_name=getString(R.string.king1);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==11){
                    final String[] chapters=getResources().getStringArray(R.array.Kings2_chapters);
                    chapter_parent_name=getString(R.string.king2);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==12){
                    final String[] chapters=getResources().getStringArray(R.array.Chronicles1_chapters);
                    chapter_parent_name=getString(R.string.chronicles1);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==13){
                    final String[] chapters=getResources().getStringArray(R.array.Chronicles2_chapters);
                    chapter_parent_name=getString(R.string.chronicles2);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                if(parent_name==14){
                    final String[] chapters=getResources().getStringArray(R.array.Ezra_chapters);
                    chapter_parent_name=getString(R.string.ezra);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==15){
                    final String[] chapters=getResources().getStringArray(R.array.Nehemiah_chapters);
                    chapter_parent_name=getString(R.string.nehemiah);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==16){
                    final String[] chapters=getResources().getStringArray(R.array.Ester_chapters);
                    chapter_parent_name=getString(R.string.ester);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==17){
                    final String[] chapters=getResources().getStringArray(R.array.Job_chapters);
                    chapter_parent_name=getString(R.string.job);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==18){
                    final String[] chapters=getResources().getStringArray(R.array.Psalms_chapters);
                    chapter_parent_name=getString(R.string.psalms);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==19){
                    final String[] chapters=getResources().getStringArray(R.array.Proverb_chapters);
                    chapter_parent_name=getString(R.string.proverbs);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==20){
                    final String[] chapters=getResources().getStringArray(R.array.Ecclesiastes_chapters);
                    chapter_parent_name=getString(R.string.ecclesiastes);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                if(parent_name==21){
                    final String[] chapters=getResources().getStringArray(R.array.Songs0ssolomon_chapters);
                    chapter_parent_name=getString(R.string.songofsolomon);

                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==22){
                    final String[] chapters=getResources().getStringArray(R.array.Isaiah_chapters);
                    chapter_parent_name=getString(R.string.isaiah);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==23){
                    final String[] chapters=getResources().getStringArray(R.array.Jeremiah_chapters);
                    chapter_parent_name=getString(R.string.jeremiah);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==24){
                    final String[] chapters=getResources().getStringArray(R.array.Lamentations_chapters);
                    chapter_parent_name=getString(R.string.lamentations);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==25){
                    final String[] chapters=getResources().getStringArray(R.array.Ezekiel_chapters);
                    chapter_parent_name=getString(R.string.ezekiel);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==26){
                    final String[] chapters=getResources().getStringArray(R.array.Daniel_chapters);
                    chapter_parent_name=getString(R.string.daniel);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==27){
                    final String[] chapters=getResources().getStringArray(R.array.Hosea1_chapters);
                    chapter_parent_name=getString(R.string.hosea);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                if(parent_name==28){
                    final String[] chapters=getResources().getStringArray(R.array.Hosea2_chapters);
                    chapter_parent_name=getString(R.string.joel);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==29){
                    final String[] chapters=getResources().getStringArray(R.array.Amos_chapters);
                    chapter_parent_name=getString(R.string.amos);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==30){
                    final String[] chapters=getResources().getStringArray(R.array.Obadiah_chapters);
                    chapter_parent_name=getString(R.string.obadiah);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==31){
                    final String[] chapters=getResources().getStringArray(R.array.Jonah_chapters);
                    chapter_parent_name=getString(R.string.jonas);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==32){
                    final String[] chapters=getResources().getStringArray(R.array.Micah_chapters);
                    chapter_parent_name=getString(R.string.micah);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==33){
                    final String[] chapters=getResources().getStringArray(R.array.Nahum_chapters);
                    chapter_parent_name=getString(R.string.nahum);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==34){
                    final String[] chapters=getResources().getStringArray(R.array.Habakkuk_chapters);
                    chapter_parent_name=getString(R.string.habakkuk);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                if(parent_name==35){
                    final String[] chapters=getResources().getStringArray(R.array.Zephaniah_chapters);
                    chapter_parent_name=getString(R.string.zephaniah);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==36){
                    final String[] chapters=getResources().getStringArray(R.array.Haggai_chapters);
                    chapter_parent_name=getString(R.string.haggai);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==37){
                    final String[] chapters=getResources().getStringArray(R.array.Zechariah_chapters);
                    chapter_parent_name=getString(R.string.zecheriah);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }
                else if(parent_name==38){
                    final String[] chapters=getResources().getStringArray(R.array.Malachi_chapters);
                    chapter_parent_name=getString(R.string.malachi);
                    intentMethod(childPosition,groupPosition,chapters,chapter_parent_name);
                }

                return true;
            }
        });




        addData();
        sendData();
    }
    public void intentMethod(int child,int parent, String[] chapters,String chapter_parent_name){
        String content=chapters[child];
        String child_name=customadapter.getChild(parent,child).toString();
        String parent_name=customadapter.getGroup(parent).toString();

        Intent intent=new Intent(getActivity(),Chapters_content.class);


        intent.putExtra("chapter_1",content);
        intent.putExtra("child_name",child_name);
        intent.putExtra("parent_name",parent_name);
        intent.putExtra("child_index",child);
        intent.putExtra("parent_index",parent);
        intent.putExtra("chapters_content",chapters);
        intent.putExtra("chapter_parent_name",chapter_parent_name);
        startActivity(intent);
    }

    void addData(){
        String chapter=getResources().getString(R.string.chapter);
        BookList=new ArrayList<>();
        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        ChapterList.add(new Chapter(chapter+" 37"," "));
        ChapterList.add(new Chapter(chapter+" 38"," "));
        ChapterList.add(new Chapter(chapter+" 39"," "));
        ChapterList.add(new Chapter(chapter+" 40"," "));
        ChapterList.add(new Chapter(chapter+" 41"," "));
        ChapterList.add(new Chapter(chapter+" 42"," "));
        ChapterList.add(new Chapter(chapter+" 43"," "));
        ChapterList.add(new Chapter(chapter+" 44"," "));
        ChapterList.add(new Chapter(chapter+" 45"," "));
        ChapterList.add(new Chapter(chapter+" 46"," "));
        ChapterList.add(new Chapter(chapter+" 47"," "));
        ChapterList.add(new Chapter(chapter+" 48"," "));
        ChapterList.add(new Chapter(chapter+" 49"," "));
        ChapterList.add(new Chapter(chapter+" 50"," "));

        BookList.add(new Books(getResources().getString(R.string.genesis),ChapterList));

        ChapterList=new ArrayList<>();
        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        ChapterList.add(new Chapter(chapter+" 37"," "));
        ChapterList.add(new Chapter(chapter+" 38"," "));
        ChapterList.add(new Chapter(chapter+" 39"," "));
        ChapterList.add(new Chapter(chapter+" 40"," "));

        BookList.add(new Books(getResources().getString(R.string.exodus),ChapterList));

        ChapterList=new ArrayList<>();
        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        BookList.add(new Books(getResources().getString(R.string.leviticus),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        BookList.add(new Books(getResources().getString(R.string.numbers),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));

        BookList.add(new Books(getResources().getString(R.string.deuteronomy),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));


        BookList.add(new Books(getResources().getString(R.string.joshua),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));

        BookList.add(new Books(getResources().getString(R.string.judges),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));

        BookList.add(new Books(getResources().getString(R.string.ruth),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));

        BookList.add(new Books(getResources().getString(R.string.samuel1),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));


        BookList.add(new Books(getResources().getString(R.string.samuel2),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));


        BookList.add(new Books(getResources().getString(R.string.king1),ChapterList));



        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));

        BookList.add(new Books(getResources().getString(R.string.king2),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        BookList.add(new Books(getResources().getString(R.string.chronicles1),ChapterList));

        ChapterList=new ArrayList<>();
        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));

        BookList.add(new Books(getResources().getString(R.string.chronicles2),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));

        BookList.add(new Books(getResources().getString(R.string.ezra),ChapterList));



        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));


        BookList.add(new Books(getResources().getString(R.string.nehemiah),ChapterList));
        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter("Chapter 1"," "));
        ChapterList.add(new Chapter("Chapter 2"," "));
        ChapterList.add(new Chapter("Chapter 3"," "));
        ChapterList.add(new Chapter("Chapter 4"," "));
        ChapterList.add(new Chapter("Chapter 5"," "));
        ChapterList.add(new Chapter("Chapter 6"," "));
        ChapterList.add(new Chapter("Chapter 7"," "));
        ChapterList.add(new Chapter("Chapter 8"," "));
        ChapterList.add(new Chapter("Chapter 9"," "));
        ChapterList.add(new Chapter("Chapter 10"," "));

        BookList.add(new Books(getResources().getString(R.string.ester),ChapterList));

        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        ChapterList.add(new Chapter(chapter+" 37"," "));
        ChapterList.add(new Chapter(chapter+" 38"," "));
        ChapterList.add(new Chapter(chapter+" 39"," "));
        ChapterList.add(new Chapter(chapter+" 40"," "));
        ChapterList.add(new Chapter(chapter+" 41"," "));
        ChapterList.add(new Chapter(chapter+" 42"," "));
        BookList.add(new Books(getResources().getString(R.string.job),ChapterList));


        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        ChapterList.add(new Chapter(chapter+" 37"," "));
        ChapterList.add(new Chapter(chapter+" 38"," "));
        ChapterList.add(new Chapter(chapter+" 39"," "));
        ChapterList.add(new Chapter(chapter+" 40"," "));
        ChapterList.add(new Chapter(chapter+" 41"," "));
        ChapterList.add(new Chapter(chapter+" 42"," "));
        ChapterList.add(new Chapter(chapter+" 43"," "));
        ChapterList.add(new Chapter(chapter+" 44"," "));
        ChapterList.add(new Chapter(chapter+" 45"," "));
        ChapterList.add(new Chapter(chapter+" 46"," "));
        ChapterList.add(new Chapter(chapter+" 47"," "));
        ChapterList.add(new Chapter(chapter+" 48"," "));
        ChapterList.add(new Chapter(chapter+" 49"," "));
        ChapterList.add(new Chapter(chapter+" 50"," "));
        ChapterList.add(new Chapter(chapter+" 51"," "));
        ChapterList.add(new Chapter(chapter+" 52"," "));
        ChapterList.add(new Chapter(chapter+" 53"," "));
        ChapterList.add(new Chapter(chapter+" 54"," "));
        ChapterList.add(new Chapter(chapter+" 55"," "));
        ChapterList.add(new Chapter(chapter+" 56"," "));
        ChapterList.add(new Chapter(chapter+" 57"," "));
        ChapterList.add(new Chapter(chapter+" 58"," "));
        ChapterList.add(new Chapter(chapter+" 59"," "));
        ChapterList.add(new Chapter(chapter+" 60"," "));
        ChapterList.add(new Chapter(chapter+" 61"," "));
        ChapterList.add(new Chapter(chapter+" 62"," "));
        ChapterList.add(new Chapter(chapter+" 63"," "));
        ChapterList.add(new Chapter(chapter+" 64"," "));
        ChapterList.add(new Chapter(chapter+" 65"," "));
        ChapterList.add(new Chapter(chapter+" 66"," "));
        ChapterList.add(new Chapter(chapter+" 67"," "));
        ChapterList.add(new Chapter(chapter+" 68"," "));
        ChapterList.add(new Chapter(chapter+" 69"," "));
        ChapterList.add(new Chapter(chapter+" 70"," "));
        ChapterList.add(new Chapter(chapter+" 71"," "));
        ChapterList.add(new Chapter(chapter+" 72"," "));
        ChapterList.add(new Chapter(chapter+" 73"," "));
        ChapterList.add(new Chapter(chapter+" 74"," "));
        ChapterList.add(new Chapter(chapter+" 75"," "));
        ChapterList.add(new Chapter(chapter+" 76"," "));
        ChapterList.add(new Chapter(chapter+" 77"," "));
        ChapterList.add(new Chapter(chapter+" 78"," "));
        ChapterList.add(new Chapter(chapter+" 79"," "));
        ChapterList.add(new Chapter(chapter+" 80"," "));
        ChapterList.add(new Chapter(chapter+" 81"," "));
        ChapterList.add(new Chapter(chapter+" 82"," "));
        ChapterList.add(new Chapter(chapter+" 83"," "));
        ChapterList.add(new Chapter(chapter+" 84"," "));
        ChapterList.add(new Chapter(chapter+" 85"," "));
        ChapterList.add(new Chapter(chapter+" 86"," "));
        ChapterList.add(new Chapter(chapter+" 87"," "));
        ChapterList.add(new Chapter(chapter+" 88"," "));
        ChapterList.add(new Chapter(chapter+" 89"," "));
        ChapterList.add(new Chapter(chapter+" 90"," "));
        ChapterList.add(new Chapter(chapter+" 91"," "));
        ChapterList.add(new Chapter(chapter+" 92"," "));
        ChapterList.add(new Chapter(chapter+" 93"," "));
        ChapterList.add(new Chapter(chapter+" 94"," "));
        ChapterList.add(new Chapter(chapter+" 95"," "));
        ChapterList.add(new Chapter(chapter+" 96"," "));
        ChapterList.add(new Chapter(chapter+" 97"," "));
        ChapterList.add(new Chapter(chapter+" 98"," "));
        ChapterList.add(new Chapter(chapter+" 99"," "));
        ChapterList.add(new Chapter(chapter+" 100"," "));
        ChapterList.add(new Chapter(chapter+" 101"," "));
        ChapterList.add(new Chapter(chapter+" 102"," "));
        ChapterList.add(new Chapter(chapter+" 103"," "));
        ChapterList.add(new Chapter(chapter+" 104"," "));
        ChapterList.add(new Chapter(chapter+" 105"," "));
        ChapterList.add(new Chapter(chapter+" 106"," "));
        ChapterList.add(new Chapter(chapter+" 107"," "));
        ChapterList.add(new Chapter(chapter+" 108"," "));
        ChapterList.add(new Chapter(chapter+" 109"," "));
        ChapterList.add(new Chapter(chapter+" 110"," "));
        ChapterList.add(new Chapter(chapter+" 111"," "));
        ChapterList.add(new Chapter(chapter+" 112"," "));
        ChapterList.add(new Chapter(chapter+" 113"," "));
        ChapterList.add(new Chapter(chapter+" 114"," "));
        ChapterList.add(new Chapter(chapter+" 115"," "));
        ChapterList.add(new Chapter(chapter+" 116"," "));
        ChapterList.add(new Chapter(chapter+" 117"," "));
        ChapterList.add(new Chapter(chapter+" 118"," "));
        ChapterList.add(new Chapter(chapter+" 119"," "));
        ChapterList.add(new Chapter(chapter+" 120"," "));
        ChapterList.add(new Chapter(chapter+" 121"," "));
        ChapterList.add(new Chapter(chapter+" 122"," "));
        ChapterList.add(new Chapter(chapter+" 123"," "));
        ChapterList.add(new Chapter(chapter+" 124"," "));
        ChapterList.add(new Chapter(chapter+" 125"," "));
        ChapterList.add(new Chapter(chapter+" 126"," "));
        ChapterList.add(new Chapter(chapter+" 127"," "));
        ChapterList.add(new Chapter(chapter+" 128"," "));
        ChapterList.add(new Chapter(chapter+" 129"," "));
        ChapterList.add(new Chapter(chapter+" 130"," "));
        ChapterList.add(new Chapter(chapter+" 131"," "));
        ChapterList.add(new Chapter(chapter+" 132"," "));
        ChapterList.add(new Chapter(chapter+" 133"," "));
        ChapterList.add(new Chapter(chapter+" 134"," "));
        ChapterList.add(new Chapter(chapter+" 135"," "));
        ChapterList.add(new Chapter(chapter+" 136"," "));
        ChapterList.add(new Chapter(chapter+" 137"," "));
        ChapterList.add(new Chapter(chapter+" 138"," "));
        ChapterList.add(new Chapter(chapter+" 139"," "));
        ChapterList.add(new Chapter(chapter+" 140"," "));
        ChapterList.add(new Chapter(chapter+" 141"," "));
        ChapterList.add(new Chapter(chapter+" 142"," "));
        ChapterList.add(new Chapter(chapter+" 143"," "));
        ChapterList.add(new Chapter(chapter+" 144"," "));
        ChapterList.add(new Chapter(chapter+" 145"," "));
        ChapterList.add(new Chapter(chapter+" 146"," "));
        ChapterList.add(new Chapter(chapter+" 147"," "));
        ChapterList.add(new Chapter(chapter+" 148"," "));
        ChapterList.add(new Chapter(chapter+" 149"," "));
        ChapterList.add(new Chapter(chapter+" 150"," "));
        BookList.add(new Books(getResources().getString(R.string.psalms),ChapterList));

        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));


        BookList.add(new Books(getResources().getString(R.string.proverbs),ChapterList));


        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));


        BookList.add(new Books(getResources().getString(R.string.ecclesiastes),ChapterList));


        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));


        BookList.add(new Books(getResources().getString(R.string.songofsolomon),ChapterList));


        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        ChapterList.add(new Chapter(chapter+" 37"," "));
        ChapterList.add(new Chapter(chapter+" 38"," "));
        ChapterList.add(new Chapter(chapter+" 39"," "));
        ChapterList.add(new Chapter(chapter+" 40"," "));
        ChapterList.add(new Chapter(chapter+" 41"," "));
        ChapterList.add(new Chapter(chapter+" 42"," "));
        ChapterList.add(new Chapter(chapter+" 43"," "));
        ChapterList.add(new Chapter(chapter+" 44"," "));
        ChapterList.add(new Chapter(chapter+" 45"," "));
        ChapterList.add(new Chapter(chapter+" 46"," "));
        ChapterList.add(new Chapter(chapter+" 47"," "));
        ChapterList.add(new Chapter(chapter+" 48"," "));
        ChapterList.add(new Chapter(chapter+" 49"," "));
        ChapterList.add(new Chapter(chapter+" 50"," "));
        ChapterList.add(new Chapter(chapter+" 51"," "));
        ChapterList.add(new Chapter(chapter+" 52"," "));
        ChapterList.add(new Chapter(chapter+" 53"," "));
        ChapterList.add(new Chapter(chapter+" 54"," "));
        ChapterList.add(new Chapter(chapter+" 55"," "));
        ChapterList.add(new Chapter(chapter+" 56"," "));
        ChapterList.add(new Chapter(chapter+" 57"," "));
        ChapterList.add(new Chapter(chapter+" 58"," "));
        ChapterList.add(new Chapter(chapter+" 59"," "));
        ChapterList.add(new Chapter(chapter+" 60"," "));
        ChapterList.add(new Chapter(chapter+" 61"," "));
        ChapterList.add(new Chapter(chapter+" 62"," "));
        ChapterList.add(new Chapter(chapter+" 63"," "));
        ChapterList.add(new Chapter(chapter+" 64"," "));
        ChapterList.add(new Chapter(chapter+" 65"," "));
        ChapterList.add(new Chapter(chapter+" 66"," "));

        BookList.add(new Books(getResources().getString(R.string.isaiah),ChapterList));





        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        ChapterList.add(new Chapter(chapter+" 37"," "));
        ChapterList.add(new Chapter(chapter+" 38"," "));
        ChapterList.add(new Chapter(chapter+" 39"," "));
        ChapterList.add(new Chapter(chapter+" 40"," "));
        ChapterList.add(new Chapter(chapter+" 41"," "));
        ChapterList.add(new Chapter(chapter+" 42"," "));
        ChapterList.add(new Chapter(chapter+" 43"," "));
        ChapterList.add(new Chapter(chapter+" 44"," "));
        ChapterList.add(new Chapter(chapter+" 45"," "));
        ChapterList.add(new Chapter(chapter+" 46"," "));
        ChapterList.add(new Chapter(chapter+" 47"," "));
        ChapterList.add(new Chapter(chapter+" 48"," "));
        ChapterList.add(new Chapter(chapter+" 49"," "));
        ChapterList.add(new Chapter(chapter+" 50"," "));
        ChapterList.add(new Chapter(chapter+" 51"," "));
        ChapterList.add(new Chapter(chapter+" 52"," "));
        BookList.add(new Books(getResources().getString(R.string.jeremiah),ChapterList));


        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));




        BookList.add(new Books(getResources().getString(R.string.lamentations),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));
        ChapterList.add(new Chapter(chapter+" 15"," "));
        ChapterList.add(new Chapter(chapter+" 16"," "));
        ChapterList.add(new Chapter(chapter+" 17"," "));
        ChapterList.add(new Chapter(chapter+" 18"," "));
        ChapterList.add(new Chapter(chapter+" 19"," "));
        ChapterList.add(new Chapter(chapter+" 20"," "));
        ChapterList.add(new Chapter(chapter+" 21"," "));
        ChapterList.add(new Chapter(chapter+" 22"," "));
        ChapterList.add(new Chapter(chapter+" 23"," "));
        ChapterList.add(new Chapter(chapter+" 24"," "));
        ChapterList.add(new Chapter(chapter+" 25"," "));
        ChapterList.add(new Chapter(chapter+" 26"," "));
        ChapterList.add(new Chapter(chapter+" 27"," "));
        ChapterList.add(new Chapter(chapter+" 28"," "));
        ChapterList.add(new Chapter(chapter+" 29"," "));
        ChapterList.add(new Chapter(chapter+" 30"," "));
        ChapterList.add(new Chapter(chapter+" 31"," "));
        ChapterList.add(new Chapter(chapter+" 32"," "));
        ChapterList.add(new Chapter(chapter+" 33"," "));
        ChapterList.add(new Chapter(chapter+" 34"," "));
        ChapterList.add(new Chapter(chapter+" 35"," "));
        ChapterList.add(new Chapter(chapter+" 36"," "));
        ChapterList.add(new Chapter(chapter+" 37"," "));
        ChapterList.add(new Chapter(chapter+" 38"," "));
        ChapterList.add(new Chapter(chapter+" 39"," "));
        ChapterList.add(new Chapter(chapter+" 40"," "));
        ChapterList.add(new Chapter(chapter+" 41"," "));
        ChapterList.add(new Chapter(chapter+" 42"," "));
        ChapterList.add(new Chapter(chapter+" 43"," "));
        ChapterList.add(new Chapter(chapter+" 44"," "));
        ChapterList.add(new Chapter(chapter+" 45"," "));
        ChapterList.add(new Chapter(chapter+" 46"," "));
        ChapterList.add(new Chapter(chapter+" 47"," "));
        ChapterList.add(new Chapter(chapter+" 48"," "));


        BookList.add(new Books(getResources().getString(R.string.ezekiel),ChapterList));


        ChapterList=new ArrayList<>();


        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));


        BookList.add(new Books(getResources().getString(R.string.daniel),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));


        BookList.add(new Books(getResources().getString(R.string.hosea),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));

        BookList.add(new Books(getResources().getString(R.string.joel),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));

        BookList.add(new Books(getResources().getString(R.string.amos),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));

        BookList.add(new Books(getResources().getString(R.string.obadiah),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));

        BookList.add(new Books(getResources().getString(R.string.jonas),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));

        BookList.add(new Books(getResources().getString(R.string.micah),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));

        BookList.add(new Books(getResources().getString(R.string.nahum),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));

        BookList.add(new Books(getResources().getString(R.string.habakkuk),ChapterList));

        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));

        BookList.add(new Books(getResources().getString(R.string.zephaniah),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));

        BookList.add(new Books(getResources().getString(R.string.haggai),ChapterList));


        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));
        ChapterList.add(new Chapter(chapter+" 5"," "));
        ChapterList.add(new Chapter(chapter+" 6"," "));
        ChapterList.add(new Chapter(chapter+" 7"," "));
        ChapterList.add(new Chapter(chapter+" 8"," "));
        ChapterList.add(new Chapter(chapter+" 9"," "));
        ChapterList.add(new Chapter(chapter+" 10"," "));
        ChapterList.add(new Chapter(chapter+" 11"," "));
        ChapterList.add(new Chapter(chapter+" 12"," "));
        ChapterList.add(new Chapter(chapter+" 13"," "));
        ChapterList.add(new Chapter(chapter+" 14"," "));


        BookList.add(new Books(getResources().getString(R.string.zecheriah),ChapterList));
        ChapterList=new ArrayList<>();

        ChapterList.add(new Chapter(chapter+" 1"," "));
        ChapterList.add(new Chapter(chapter+" 2"," "));
        ChapterList.add(new Chapter(chapter+" 3"," "));
        ChapterList.add(new Chapter(chapter+" 4"," "));

        BookList.add(new Books(getResources().getString(R.string.malachi),ChapterList));



        sendData();

    }
    void sendData(){
        customadapter=new Custom_adapter1(BookList,this.getContext());
        expandableListView.setAdapter(customadapter);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.setting:
                Toast.makeText(getActivity(), "fragment", Toast.LENGTH_SHORT).show();

                return false;


            default:
                break;
        }

        return false;
    }

}


