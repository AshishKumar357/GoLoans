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

public class RegisterPwd extends AppCompatActivity {

    Button previousBtn, finishBtn;
    EditText inppwd, cnfpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pwd);

        previousBtn = findViewById(R.id.previousbtnPWD);
        finishBtn = findViewById(R.id.FinishBtnPWD);
        cnfpwd = findViewById(R.id.cnfPwd);
        inppwd = findViewById(R.id.inpPwd);

        cnfpwd.setText("");
        inppwd.setText("");

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("MYPREF", MODE_PRIVATE);

                String newpwd = inppwd.getText().toString();
                String newcnfpwd = cnfpwd.getText().toString();


                if ("".equals(newpwd) || "".equals(newcnfpwd)) {
                    Toast.makeText(RegisterPwd.this, "Password Fields are Compulsory ", Toast.LENGTH_SHORT).show();
                    cnfpwd.setText("");
                    inppwd.setText("");
                } else if (!isValidPassword(newpwd)) {
                    Toast.makeText(RegisterPwd.this, "Password must contain mix of upper " +
                                    "and lower case letters as well as digits and one special charecter(4-20) ",
                            Toast.LENGTH_SHORT).show();
                    cnfpwd.setText("");
                    inppwd.setText("");
                }
                else if (!newpwd.equals(newcnfpwd))
                {
                    Toast.makeText(RegisterPwd.this, "Password Mismatch ", Toast.LENGTH_SHORT).show();
                    cnfpwd.setText("");
                    inppwd.setText("");
                }
                else {
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putString(newUser + newpwd + "Data", newUser + "\n" + newmail + "\n" + newphno);
//                    editor.putString(newUser + "a", newUser);
//                    editor.putString(newpwd + "pwd", newpwd);
//                    editor.apply();

                    Intent intent = new Intent(RegisterPwd.this, Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        });
    }
        public static boolean isValidPassword(String password) {
            Matcher matcher = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{4,20})").matcher(password);
            return matcher.matches();
        }
}
