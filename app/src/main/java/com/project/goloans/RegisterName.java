package com.project.goloans;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class RegisterName extends AppCompatActivity {

    private static final String TAG = "TAG";
    Button previousbtn, nextbtn;
    EditText inpFirstName, inpMiddleName, inpLastName;

    RewardedAd rewardedAd;

    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_name);

        nextbtn = findViewById(R.id.nextBtnN);
        previousbtn = findViewById(R.id.previousbtnN);
        inpFirstName = findViewById(R.id.inpFN);
        inpMiddleName = findViewById(R.id.inpMN);
        inpLastName = findViewById(R.id.inpLN);


        inpFirstName.setText("");
        inpMiddleName.setText("");
        inpLastName.setText("");

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("MYPREF", MODE_PRIVATE);

                String newfn = inpFirstName.getText().toString();
                String newmn = inpMiddleName.getText().toString();
                String newln = inpLastName.getText().toString();


                if ("".equals(newfn)) {
                    Toast.makeText(RegisterName.this, "First Name Field is Compulsory ", Toast.LENGTH_SHORT).show();
                } else {
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putString(newUser + newpwd + "Data", newUser + "\n" + newmail + "\n" + newphno);
//                    editor.putString(newUser + "a", newUser);
//                    editor.putString(newpwd + "pwd", newpwd);
//                    editor.apply();

                    Intent intent = new Intent(RegisterName.this, RegisterEmailPhno.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        });

        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterName.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    public void loadAd(View view) {
        this.rewardedAd = new RewardedAd(this, "ca-app-pub-3940256099942544/5224354917");
        RewardedAdLoadCallback callback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdFailedToLoad(int i) {
                super.onRewardedAdFailedToLoad(i);
                Log.i(TAG, "OnRewardedAdFailedToLoad");
            }

            @Override
            public void onRewardedAdLoaded() {
                super.onRewardedAdLoaded();
                Log.i(TAG, "OnRewardedAdLoaded");
            }
        };
        this.rewardedAd.loadAd(new AdRequest.Builder().build(), callback);
    }

}