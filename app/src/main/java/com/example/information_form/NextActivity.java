package com.example.information_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    TextView fname,lname,age,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Bundle bundle=getIntent().getExtras();

        fname=findViewById(R.id.firstnamevalue);
        lname=findViewById(R.id.lastnamevalue);
        age=findViewById(R.id.agevalue);
        gender=findViewById(R.id.gendervalue);

        fname.setText(bundle.getCharSequence("First Name"));
        lname.setText(bundle.getCharSequence("Last Name"));
        age.setText(bundle.getCharSequence("age"));
        gender.setText(bundle.getCharSequence("gender"));
    }
}
