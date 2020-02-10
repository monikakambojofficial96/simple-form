package com.example.information_form;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText fname,lname;
    RadioGroup gender;
    Spinner age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=findViewById(R.id.button);
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        gender=findViewById(R.id.radioGroup);
        age=findViewById(R.id.spinner);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("AGE");


        for (int i = 18; i <= 60; i++)

             arrayList.add(i + "");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.spinner,arrayList);

        arrayAdapter.setDropDownViewResource(R.layout.dropdown_spinner);

        age.setAdapter(arrayAdapter);

        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                String age=parent.getItemAtPosition(position).toString();
//
//                Toast.makeText(parent.getContext(),"selected " +age,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),NextActivity.class);

               Bundle bundle=new Bundle();

               bundle.putString("First Name",fname.getText().toString());
               bundle.putString("Last Name",lname.getText().toString());
               bundle.putString("age",age.getSelectedItem().toString());

               int id=gender.getCheckedRadioButtonId();

               RadioButton radioButton=findViewById(id);

               bundle.putString("gender",radioButton.getText().toString());

               intent.putExtras(bundle);

               startActivity(intent);
            }
        });

    }
}
