package com.project.goloans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;


public class Home extends AppCompatActivity {

    TextView textView, textView2;
    Toolbar toolbar;
    Button applybtn, lendbtn, blogbtn, aboutbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        toolbar= findViewById(R.id.toolbar3);
        textView=findViewById(R.id.textView);
        textView2= findViewById(R.id.textView2);
        applybtn= findViewById(R.id.applybtn);
        lendbtn= findViewById(R.id.lendbtn);
        blogbtn = findViewById(R.id.blogbtn);
        aboutbtn= findViewById(R.id.aboutbtn);

        SharedPreferences sp=getSharedPreferences("MYPREF", MODE_PRIVATE);
        String display= sp.getString("display","");
        // toolbar.setTitle(sp.getString("uname",""));

        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this,ApplyActivity.class);
                startActivity(intent);
            }
        });

        lendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this,LenderActivity.class);
                startActivity(intent);
            }
        });
        blogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this,BlogActivity.class);
                startActivity(intent);
            }
        });
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this,AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}