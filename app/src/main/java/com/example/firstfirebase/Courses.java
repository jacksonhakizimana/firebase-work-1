package com.example.firstfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Courses extends AppCompatActivity {
 ListView etList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        etList = (ListView) findViewById(R.id.etList);
        ArrayList<String> Jackhan = new ArrayList<String>();
        Jackhan.add("Mathematics");
        Jackhan.add("Physics");
        Jackhan.add("Mobile Application");
        Jackhan.add("Chemistry");
        Jackhan.add("Data Mining");
        Jackhan.add("Biology");
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Jackhan);
        etList.setAdapter(Adapter);
        etList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                  Intent intent=new Intent(Courses.this, Notes.class);
                   startActivity(intent);
                    Toast.makeText(Courses.this, "Welcome to Mathematics", Toast.LENGTH_SHORT).show();
                }else if (position==1){
                    Intent intent=new Intent(Courses.this,Physics.class);
                    startActivity(intent);
                    Toast.makeText(Courses.this, "Welcome to Physics Notes", Toast.LENGTH_SHORT).show();
                }else if (position==2){
                    Intent intent = new Intent(Courses.this,Mobile.class);
                    startActivity(intent);
                    Toast.makeText(Courses.this, "Welcome to Mobile Application Notes", Toast.LENGTH_SHORT).show();
                }else if (position==3){
                        Intent intent = new Intent(Courses.this,Chemistry.class);
                        startActivity(intent);
                        Toast.makeText(Courses.this, "Welcome to Chemistry Notes", Toast.LENGTH_SHORT).show();
                    }else if (position==4){
                    Intent intent = new Intent(Courses.this,Datamining.class);
                    startActivity(intent);
                    Toast.makeText(Courses.this, "Welcome to Data Mining Notes", Toast.LENGTH_SHORT).show();
                }else if (position==5){
                    Intent intent = new Intent(Courses.this,Biology.class);
                    startActivity(intent);
                    Toast.makeText(Courses.this, "Welcome to Biology Notes", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
