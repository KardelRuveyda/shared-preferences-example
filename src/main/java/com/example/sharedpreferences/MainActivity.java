package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userNameEditText;
    EditText ageEditText;
    EditText weightEditText;
    EditText heightEditText;
    CheckBox femaleCheckBox;
    CheckBox maleCheckBox;
    Button   saveButton;
    Button   showButton;

    String username;

    String age;
    String weight;
    String height;
    Boolean male;
    Boolean female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText =(EditText) findViewById(R.id.Username);
        ageEditText =(EditText) findViewById(R.id.Age);
        weightEditText =(EditText) findViewById(R.id.Weight);
        heightEditText = (EditText) findViewById(R.id.Height);
        maleCheckBox = (CheckBox) findViewById(R.id.checkBoxErkek);
        femaleCheckBox = (CheckBox) findViewById(R.id.checkboxKadin);
        saveButton = (Button) findViewById(R.id.save_button);
        showButton =(Button) findViewById(R.id.show_text_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences("Enter",MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();

                username = userNameEditText.getText().toString();
                age = ageEditText.getText().toString();
                weight = weightEditText.getText().toString();
                height = heightEditText.getText().toString();
                male = maleCheckBox.isChecked();
                female = femaleCheckBox.isChecked();

                editor.putString("UserName",username);
                editor.putString("Age",age);
                editor.putString("Weight",weight);
                editor.putString("Height", height);
                editor.putBoolean("Male",male);
                editor.putBoolean("FeMale",female);

                editor.commit();

                userNameEditText.getText().clear();
                ageEditText.getText().clear();
                weightEditText.getText().clear();
                heightEditText.getText().clear();
                femaleCheckBox.clearFocus();
                maleCheckBox.clearFocus();


                Toast.makeText(getApplicationContext(),"Succesful Registered!",Toast.LENGTH_LONG).show();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedVeriOku = getSharedPreferences("Enter",MODE_PRIVATE);

                userNameEditText.setText(sharedVeriOku.getString("UserName",""));
                ageEditText.setText(sharedVeriOku.getString("Age",""));
                weightEditText.setText(sharedVeriOku.getString("Weight",""));
                heightEditText.setText(sharedVeriOku.getString("Height",""));
                maleCheckBox.setChecked(sharedVeriOku.getBoolean("Male",false));
                femaleCheckBox.setChecked(sharedVeriOku.getBoolean("FeMale",false));
            }
        });
    }
}
