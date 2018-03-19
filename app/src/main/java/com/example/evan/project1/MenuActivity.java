package com.example.evan.project1;

/*
Evan Jensen - Project 1 (Mobile App Development) - March 2018

The purpose of this project is to design daily food plan. The
program makes a daily menu allowing you to quickly design each
meal (breakfast, lunch, and dinner) using a selection of food.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    String userGender, userAgeRange, userActivity;
    Integer minCals, maxCals;
    TextView labelUserSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView menuList = (RecyclerView) findViewById(R.id.cardList);
        menuList.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        menuList.setLayoutManager(layout);

        // Collect data from form
        Intent intent = getIntent();
        userGender = intent.getStringExtra("Gender");
        userAgeRange = intent.getStringExtra("AgeRange");
        userActivity = intent.getStringExtra("Activity");
        getMaxCals();
        getMinCals();

        // Set up headings and text
        setTitle("Today's Meals");
        labelUserSummary = (TextView) findViewById(R.id.labelUserSummary);
        String userSummary = "Tap to Refresh Menu";
        labelUserSummary.setText(userSummary);

        // Initiate modified "ContactAdapter" to create CardViews (Meals) for RecyclerView (Menu)
        ContactAdapter ca = new ContactAdapter(createMenu());
        menuList.setAdapter(ca);
    }

    // Method to build menu out of customized meals
    private List createMenu() {
        List menuList = new ArrayList();
        int dailyCalTotal = 0;

        // Create Breakfast Menu
        MakeBreakfast makeBreakfast = new MakeBreakfast(maxCals, minCals);
        ArrayList<FoodItem> breakfastList = makeBreakfast.getNewBreakfast();
        MenuCard breakfast = new MenuCard();
        breakfast.title = "Breakfast";
        breakfast.food = getMealFood(breakfastList);
        breakfast.calories = getMealCalories(breakfastList);
        breakfast.totalCal = getMealTotalCal(breakfastList);
        dailyCalTotal = dailyCalTotal + getMealCalInt(breakfastList);
        menuList.add(breakfast);

        // Create Lunch Menu
        MakeLunch makeLunch = new MakeLunch(maxCals, minCals);
        ArrayList<FoodItem> lunchList = makeLunch.getNewLunch();
        MenuCard lunch = new MenuCard();
        lunch.title = "Lunch";
        lunch.food = getMealFood(lunchList);
        lunch.calories = getMealCalories(lunchList);
        lunch.totalCal = getMealTotalCal(lunchList);
        dailyCalTotal = dailyCalTotal + getMealCalInt(lunchList);
        menuList.add(lunch);

        // Create Dinner Menu
        MakeDinner makeDinner = new MakeDinner(maxCals, minCals);
        ArrayList<FoodItem> dinnerList = makeDinner.getNewDinner();
        MenuCard dinner = new MenuCard();
        dinner.title = "Dinner";
        dinner.food = getMealFood(dinnerList);
        dinner.calories = getMealCalories(dinnerList);
        dinner.totalCal = getMealTotalCal(dinnerList);
        dailyCalTotal = dailyCalTotal + getMealCalInt(dinnerList);
        menuList.add(dinner);

        // Create Summary Card
        MenuCard summary = new MenuCard();
        summary.title = "Total Calories: " + dailyCalTotal;
        summary.food = "This is in the range of daily recommended values for " + userAgeRange + " year old, " + userActivity.toLowerCase() + " " + userGender.toLowerCase() + "s";
        menuList.add(summary);

        return menuList;

    }

    // Returns list of food in meal
    private String getMealFood(ArrayList<FoodItem> importList) {
        String foodList = "";
        for (int i = 0; i < importList.size(); i++) {
            String newFoodItem = importList.get(i).getFood();
            foodList = foodList.concat(newFoodItem + "\n");
        }
        return foodList;
    }

    // Returns list of calories in meal
    private String getMealCalories(ArrayList<FoodItem> importList){
        int total = 0;
        String caloriesList = "";
        for (int i = 0; i < importList.size(); i++) {
            int newCalCount = importList.get(i).getCalories();
            total = total + newCalCount;
            caloriesList = caloriesList.concat(String.valueOf(newCalCount) + "\n");
        }
        return caloriesList;
    }

    // Returns total meal calories as descriptive string
    private String getMealTotalCal(ArrayList<FoodItem> importList){
        int total = 0;
        String caloriesList = "";
        for (int i = 0; i < importList.size(); i++) {
            int newCalCount = importList.get(i).getCalories();
            total = total + newCalCount;
            caloriesList = caloriesList.concat(String.valueOf(newCalCount) + "\n");
        }
        //totalCals = totalCals + total;
        return "Total meal calories: " + String.valueOf(total);
    }

    // Returns total meal calories as integer
    private int getMealCalInt(ArrayList<FoodItem> importList){
        int total = 0;
        String caloriesList = "";
        for (int i = 0; i < importList.size(); i++) {
            int newCalCount = importList.get(i).getCalories();
            total = total + newCalCount;
            caloriesList = caloriesList.concat(String.valueOf(newCalCount) + "\n");
        }
        return total;
    }

    // Calculate max daily calories per gender, age, and activity level
    public void getMaxCals() {
        if (userGender.equals("Male")) {
            if (userActivity.equals("Sedentary") && userAgeRange.equals("2-3"))
                maxCals = 1000;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("4-8"))
                maxCals = 1400;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("9-13"))
                maxCals = 1800;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("14-18"))
                maxCals = 2200;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("19-30"))
                maxCals = 2400;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("31-50"))
                maxCals = 2200;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("50+"))
                maxCals = 2000;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("2-3"))
                maxCals = 1400;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("4-8"))
                maxCals = 1600;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("9-13"))
                maxCals = 2200;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("14-18"))
                maxCals = 2800;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("19-30"))
                maxCals = 2800;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("31-50"))
                maxCals = 2600;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("50+"))
                maxCals = 2400;
            if (userActivity.equals("Active") && userAgeRange.equals("2-3"))
                maxCals = 1400;
            if (userActivity.equals("Active") && userAgeRange.equals("4-8"))
                maxCals = 2000;
            if (userActivity.equals("Active") && userAgeRange.equals("9-13"))
                maxCals = 2600;
            if (userActivity.equals("Active") && userAgeRange.equals("14-18"))
                maxCals = 3200;
            if (userActivity.equals("Active") && userAgeRange.equals("19-30"))
                maxCals = 3000;
            if (userActivity.equals("Active") && userAgeRange.equals("31-50"))
                maxCals = 3000;
            if (userActivity.equals("Active") && userAgeRange.equals("50+"))
                maxCals = 2800;

        }
        if(userGender.equals("Female")){
            if (userActivity.equals("Sedentary") && userAgeRange.equals("2-3"))
                maxCals = 1000;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("4-8"))
                maxCals = 1200;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("9-13"))
                maxCals = 1600;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("14-18"))
                maxCals = 1800;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("19-30"))
                maxCals = 2000;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("31-50"))
                maxCals = 1800;
            if (userActivity.equals("Sedentary") && userAgeRange.equals("50+"))
                maxCals = 1600;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("2-3"))
                maxCals = 1400;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("4-8"))
                maxCals = 1600;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("9-13"))
                maxCals = 2000;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("14-18"))
                maxCals = 2000;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("19-30"))
                maxCals = 2200;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("31-50"))
                maxCals = 2000;
            if (userActivity.equals("Moderately Active") && userAgeRange.equals("50+"))
                maxCals = 1800;
            if (userActivity.equals("Active") && userAgeRange.equals("2-3"))
                maxCals = 1400;
            if (userActivity.equals("Active") && userAgeRange.equals("4-8"))
                maxCals = 1800;
            if (userActivity.equals("Active") && userAgeRange.equals("9-13"))
                maxCals = 2200;
            if (userActivity.equals("Active") && userAgeRange.equals("14-18"))
                maxCals = 2400;
            if (userActivity.equals("Active") && userAgeRange.equals("19-30"))
                maxCals = 2400;
            if (userActivity.equals("Active") && userAgeRange.equals("31-50"))
                maxCals = 2200;
            if (userActivity.equals("Active") && userAgeRange.equals("50+"))
                maxCals = 2200;
        }
    }

    // Calculate min (70%) daily calories based on max
    public void getMinCals(){
        minCals = (maxCals*4/5);
    }

    public void refreshMenu(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        Toast.makeText(MenuActivity.this, "Here's your new menu", Toast.LENGTH_LONG).show();
    }

}