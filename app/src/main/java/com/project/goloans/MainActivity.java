package com.project.goloans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button loginbtn,signbtn;
    EditText inputUname, inputPwd;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        loginbtn=findViewById(R.id.Loginbtn);
        signbtn=findViewById(R.id.signbtn);
        inputPwd=findViewById(R.id.ipwd);
        inputUname=findViewById(R.id.iname);

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterName.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = inputUname.getText().toString();
                String pwd = inputPwd.getText().toString();

                SharedPreferences sp = getSharedPreferences("MYPREF",MODE_PRIVATE);

                String userDetails = sp.getString(user + pwd + "Data","Username OR Password is incorrect");
                String sp_uname=sp.getString(user+ "a","Guest");
                String sp_pwd=sp.getString(pwd+ "pwd","Guest");

                SharedPreferences.Editor editor= sp.edit();
                editor.putString("display",userDetails);
                editor.putString("uname",sp_uname);
                editor.apply();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if (!Objects.equals(sp.getString(user + "a", "Guest"), "Guest") && !Objects.equals(sp.getString(pwd + "pwd", "Guest"), "Guest")) {
                        Intent intent=new Intent(MainActivity.this,Home.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Email or Password seem incorrect", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });


    }

}