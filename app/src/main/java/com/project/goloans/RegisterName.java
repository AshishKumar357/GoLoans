package com.project.goloans;


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

public class RegisterName extends AppCompatActivity {

    Button previousbtn,nextbtn;
    EditText inpFirstName,inpMiddleName,inpLastName;

    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_name);

        nextbtn=findViewById(R.id.nextBtnN);
        previousbtn=findViewById(R.id.previousbtnN);
        inpFirstName=findViewById(R.id.inpFN);
        inpMiddleName=findViewById(R.id.inpMN);
        inpLastName=findViewById(R.id.inpLN);


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


                if ("".equals(newfn)){
                    Toast.makeText(RegisterName.this, "First Name Field is Compulsory ", Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(newln) && "".equals(newmn) ){
                    Toast.makeText(RegisterName.this, "No Middle Name or Last name will be registered ", Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(newmn)){
                    Toast.makeText(RegisterName.this, "No Fiddle name will be registered ", Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(newln)){
                    Toast.makeText(RegisterName.this, "No Last name will be registered ", Toast.LENGTH_SHORT).show();
                }

                else {
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


    }



}