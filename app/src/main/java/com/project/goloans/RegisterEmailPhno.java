package com.project.goloans;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterEmailPhno extends AppCompatActivity {
    Button Nextbtn,previousbtn;
    EditText inpEMail,inpPhno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email_phno);

        inpEMail=findViewById(R.id.impEMail);
        inpPhno=findViewById(R.id.inpPhno);
        Nextbtn=findViewById(R.id.nextbtnEP);
        previousbtn=findViewById(R.id.previousbtnEP);

        inpEMail.setText("");
        inpPhno.setText("");

        Nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("MYPREF", MODE_PRIVATE);

                String newmail = inpEMail.getText().toString();
                String newphno = inpPhno.getText().toString();

                if ("".equals(newmail)){
                    Toast.makeText(RegisterEmailPhno.this, "Email Field is Compulsory ", Toast.LENGTH_SHORT).show();
                }
                else   if (!isEmailValid(newmail)){
                    Toast.makeText(RegisterEmailPhno.this, "Email Field is badly formatted ", Toast.LENGTH_SHORT).show();
                    inpEMail.setText("");
                }
                else if ("".equals(newphno)){
                    Toast.makeText(RegisterEmailPhno.this, "Phone Number Field is Compulsory ", Toast.LENGTH_SHORT).show();
                }
                else if (!isValidMobile(newphno)){
                    Toast.makeText(RegisterEmailPhno.this, "Phone Number Field is badly formatted ", Toast.LENGTH_SHORT).show();
                    inpPhno.setText("");
                }
                else {
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putString(newUser + newpwd + "Data", newUser + "\n" + newmail + "\n" + newphno);
//                    editor.putString(newUser + "a", newUser);
//                    editor.putString(newpwd + "pwd", newpwd);
//                    editor.apply();

                    Intent intent = new Intent(RegisterEmailPhno.this, RegisterPwd.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        });
    }

    private boolean isValidMobile(String newphno) {
        return newphno.length() == 10 && !newphno.startsWith("0");
    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
