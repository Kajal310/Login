package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttempts;
    private Button eCancel;

    private String Username = "Kajal";
    private String Password = "18it121";

    boolean isValid = false;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName=findViewById(R.id.etName);
        ePassword=findViewById(R.id.etPassword);
        eLogin=findViewById(R.id.btnLogin);
        eAttempts=findViewById(R.id.tvAttempts);
        eCancel=findViewById(R.id.btnCancel);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter details correctly!",Toast.LENGTH_LONG).show();
                }
                else{

                    isValid = validate(inputName,inputPassword);

                    if (!isValid){
                        counter--;

                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER,100,0);

                        TextView tv = new TextView(MainActivity.this);
                        tv.setBackgroundColor(Color.RED);
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(25);
                        tv.setText("Incorrect Credentials!!");
                        toast.setView(tv);
                        toast.show();

                        eAttempts.setText("No. of attempts left: "+ counter);

                        if(counter == 0){
                            eLogin.setEnabled(false);
                        }

                    } else {
                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER,100,0);

                        TextView tv = new TextView(MainActivity.this);
                        tv.setBackgroundColor(Color.GREEN);
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(25);
                        tv.setText("Login Successful!!");
                        toast.setView(tv);
                        toast.show();

                        Intent intent = new Intent(MainActivity.this, green.class);
                        startActivity(intent);
                    }
                }
            }
        });
        eCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    private boolean validate(String name, String password){
        if (name.equals(Username) && password.equals(Password)){
            return true;
        }
        return false;
    }
}
