package com.example.max.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loadButton;
    Button saveButton;
    EditText saveText;
    EditText loadText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadButton = (Button) findViewById(R.id.loadButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveText = (EditText) findViewById(R.id.saveText);
        loadText = (EditText) findViewById(R.id.loadText);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);

    }

    public void onClick(View view){

        if(view.getId() == R.id.saveButton){

            Context context = getBaseContext();
            SharedPreferences sharedPref = context.getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.saved_text), saveText.getText().toString());
            editor.commit();

        }

       else{

            Context context = getBaseContext();
            SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            String savedText = sharedPref.getString(getString(R.string.saved_text), "default");
            loadText.setText(savedText);

        }

    }


}
