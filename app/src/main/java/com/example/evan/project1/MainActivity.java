package com.example.evan.project1;

/*
Evan Jensen - Project 1 (Mobile App Development) - March 2018

The purpose of this project is to design daily food plan. The
program makes a daily menu allowing you to quickly design each
meal (breakfast, lunch, and dinner) using a selection of food.

Summary of user story and behind the scenes processes:
1. User enters details (Age range, gender, activity level)
2. When button is clicked, method collects data and stores as
   local variables
3. Max and target (min) calories are calculated for user case
4. Min/Max are passed to menu creation methods and classes
5. Meal items are selected randomly for each meal, looped until
   number of calories per meal is less than 1/3 max daily cals
   per day (used to simplify methods to ensure calories are
   within limits per user requirements
6. Meal lists are combined into menu list, which is fed to the
   method that creates the recycler view.
7. RecyclerView creates MenuCards (CardViews) for each meal
8. Recycler view is displayed on MenuActivity to show meals
9. Pressing "refresh" button at top of menu restarts activity,
   which re-generates the menu with arguments (min/max per user)
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String userGender, userAgeRange, userActivity;
    RadioGroup radioGroupGender;
    RadioButton selectedGender;
    Spinner spinnerAgeRange, spinnerActivity;

    @Override
    // When app launches...
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Meal Planner");
        createDropdowns();

    }

    // Create lists for spinners (dropdown menus)...
    public void createDropdowns(){
        Spinner dropdownAge = findViewById(R.id.spinnerAge);
        Spinner dropdownActivity = findViewById(R.id.spinnerActivity);
        String[] ageRanges = new String[]{"2-3","4-8","9-13","14-18","19-30","31-50","50+"};
        String[] activityRanges = new String[]{"Sedentary","Moderately Active","Active"};
        ArrayAdapter<String> adapterAge = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ageRanges);
        ArrayAdapter<String> adapterActivity = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, activityRanges);
        dropdownAge.setAdapter(adapterAge);
        dropdownActivity.setAdapter(adapterActivity);
    }

    // When "Reset" button is pressed...
    public void resetApp(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    // When "Plan Meal" button is pressed...
    public void collectUserData(View view) {
        userGender = getUserGender();
        userAgeRange = getUserAgeRange();
        userActivity = getUserActivity();
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        intent.putExtra("Gender", userGender);
        intent.putExtra("AgeRange", userAgeRange);
        intent.putExtra("Activity", userActivity);
        startActivity(intent);
    }

    // Methods to collect data from form
        // Method to get the user-selected gender
        private String getUserGender() {
            radioGroupGender = (RadioGroup) findViewById(R.id.radioGroup_gender);
            int selectedId = radioGroupGender.getCheckedRadioButtonId();
            selectedGender = findViewById(selectedId);
            return selectedGender.getText().toString();
        }

        // Method to get the user-selected age range
        private String getUserAgeRange() {
            spinnerAgeRange = (Spinner) findViewById(R.id.spinnerAge);
            return spinnerAgeRange.getSelectedItem().toString();
        }

        // Method to get the user-selected activity
        private String getUserActivity() {
            spinnerActivity = (Spinner) findViewById(R.id.spinnerActivity);
            return spinnerActivity.getSelectedItem().toString();
        }


}
