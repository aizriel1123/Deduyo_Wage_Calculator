package com.example.deduyo_wage_calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class mainOutputView extends AppCompatActivity {
    TextView name, type, totalWage, regWage, OTWage, time, OT;
    Button back;

    @SuppressLint("SourceLockedOrientationActivity")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.outputwage);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        name = findViewById(R.id.outputName);
        type = findViewById(R.id.outputType);
        totalWage = findViewById(R.id.wageOutput);
        regWage = findViewById(R.id.regOutput);
        OTWage = findViewById(R.id.OTwageOutput);
        time = findViewById(R.id.timeOutput);
        OT = findViewById(R.id.OTOutput);


        //back button
        back = findViewById(R.id.button2);
        back.setOnClickListener(v -> {
            Intent back = new Intent(this, mainInputView.class);
            startActivity(back);
        });

        //intent
        Intent output = getIntent();
        String Name = output.getStringExtra("name");
        String Type = output.getStringExtra("type");
        int Time = output.getIntExtra("time",0);
        name.setText(Name);
        type.setText(Type);
        WageController.Calculator(Type, Time);
        WageController.Output(totalWage, regWage, OTWage, time, OT);

    }
}
