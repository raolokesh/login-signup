package com.lokesh.loginsignup.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.lokesh.loginsignup.R;

import com.lokesh.loginsignup.adapter.notesViewAdapter;
import com.lokesh.loginsignup.database.notesEntity;
import com.lokesh.loginsignup.database.notesHelper;
import com.lokesh.loginsignup.database.userEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class notes_layout extends AppCompatActivity {
    Toolbar toolbar;

    ListView listview_notes;

    List<notesEntity> data = new ArrayList<notesEntity>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_layout);

        notesHelper noteshelper = new notesHelper(this);

        listview_notes = findViewById(R.id.listview_notes);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().isHideOnContentScrollEnabled();
        getSupportActionBar().setTitle("Notes");


        Date date = new Date();


        Intent intentData = getIntent();
        String username = intentData.getStringExtra("username");
        noteshelper.insertnotes("hello we are going ","we are going to add temperature data to this ",date.toString(),"lokesh@gmail.com" );
        noteshelper.insertnotes("hello we ar23e going234 ","we are going to ad132 23dsfcbd temperature data to this ",date.toString(),"lokesh@gmail.com" );
        noteshelper.insertnotes("hello we a324re going 234","we are gocvxnbxcing to add temperature data to this ",date.toString(),"lokesh@gmail.com" );
        noteshelper.insertnotes("hello we 32are going32 ","we are goinzbbzbg to add temperature data to this ",date.toString(),"lokesh@gmail.com" );

        data = noteshelper.getnotes(username);

        notesViewAdapter notesviewAdapter = new notesViewAdapter(getApplicationContext(),data);


        listview_notes.setAdapter(notesviewAdapter);




    }
}