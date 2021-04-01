package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void generateTimeTable(int number){

        ArrayList<Integer> tables = new ArrayList<>();

        for(int i =0;i<20;i++){

            tables.add(number*(i+1));

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, tables);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(19);

        int startingPosition = 5;

        seekBar.setProgress(startingPosition);

        generateTimeTable(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int number = progress+1;

                generateTimeTable(number);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}