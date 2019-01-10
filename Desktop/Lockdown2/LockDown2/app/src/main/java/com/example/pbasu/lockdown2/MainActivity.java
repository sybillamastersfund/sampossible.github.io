package com.example.pbasu.lockdown2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    private Spinner mSpinnerRooms;
    private ArrayAdapter<CharSequence> mArrayAdapter;
    private SeekBar mThreatSeekBar;
    private Button mSubmitButton;
    private String threat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSpinnerRooms = (Spinner) findViewById(R.id.spinnerRooms);
        mArrayAdapter = ArrayAdapter.createFromResource(this, R.array.rooms, android.R.layout.simple_spinner_item);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerRooms.setAdapter(mArrayAdapter);
        mSpinnerRooms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(24);
                if (((String) parent.getItemAtPosition(position)).equals("What room are you located in?")) {

                } else {

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mThreatSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mThreatSeekBar.setEnabled(false);
        mThreatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 3) {
                    threat = "green";
                } else if (progress < 6) {
                    threat = "yellow";
                } else if (progress < 9) {
                    threat = "red";
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatabaseReference usersRef = ref.child("users");

                Map<String, User> users = new HashMap<>();
                users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));

                usersRef.setValue(users);

            }
        });

    }}








