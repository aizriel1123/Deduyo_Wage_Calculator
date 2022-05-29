package com.example.deduyo_wage_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deduyo_wage_calculator.R;

import java.util.Objects;


public class mainInputView extends AppCompatActivity {
    Button calculate;
    EditText name, time;
    Spinner type;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inputwage);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        calculate = findViewById(R.id.calculate);
        name = findViewById(R.id.inputName);
        time = findViewById(R.id.inputTime);
        type = findViewById(R.id.inputType);

        WageModel variable = new WageModel();

        calculate.setOnClickListener(v -> {
            variable.setName(String.valueOf(name.getText()));
            variable.setType(String.valueOf(type.getSelectedItem()));
            variable.setTime(Integer.parseInt(time.getText().toString()));

            Intent input = new Intent(mainInputView.this,mainOutputView.class);
            input.putExtra("name",variable.getName());
            input.putExtra("type",variable.getType());
            input.putExtra("time",variable.getTime());
            startActivity(input);
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.employeeTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);

    }
}

