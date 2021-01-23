package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar calendar;
    int day , month,year,hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText birthday = findViewById(R.id.eddate);
        final EditText revdate = findViewById(R.id.edrevdate);
        final EditText revtime = findViewById(R.id.edrevtime);

        birthday.setInputType(InputType.TYPE_NULL);
        revdate.setInputType(InputType.TYPE_NULL);
        revtime.setInputType(InputType.TYPE_NULL);

         calendar = Calendar.getInstance();
         year = calendar.get(Calendar.YEAR);
         month = calendar.get(Calendar.MONTH);
         day = calendar.get(Calendar.DAY_OF_MONTH);
         hour = calendar.get(Calendar.HOUR_OF_DAY);
         minute = calendar.get(Calendar.MINUTE);

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         birthday.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        revdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        revdate.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        revtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        revtime.setText(hourOfDay+" : "+minute);
                    }
                },hour,minute,true);
                timePickerDialog.setTitle("choose time ");
                timePickerDialog.show();
            }
        });
    }
}