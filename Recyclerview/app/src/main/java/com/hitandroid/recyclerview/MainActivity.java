package com.hitandroid.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvFood;
    private FoodAdapter foodAdapter;
    private List<Food> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvFood = findViewById(R.id.rcv_food);
        create();
        foodAdapter = new FoodAdapter( this, foods);

        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvFood.setAdapter(foodAdapter);
        rcvFood.setLayoutManager(linearLayoutManager);
    }
    private void create() {
        foods.add(new Food(R.drawable.humberger, "Hamburger", "Chicken Burger", "RS 300.00"));
        foods.add(new Food(R.drawable.humberger, "Hamburger", "Beef Burger", "RS 350.00"));
        foods.add(new Food(R.drawable.pizza, "Pizza", "Chicken Pizza", "RS 200.00"));
        foods.add(new Food(R.drawable.pizza, "Pizza", "Fish Pizza", "RS 350.00"));
        foods.add(new Food(R.drawable.humberger, "Hamburger", "Fish Burger", "RS 250.00"));
        foods.add(new Food(R.drawable.pizza, "Pizza", "Beef Pizza", "RS 300.00"));
        foods.add(new Food(R.drawable.humberger, "Hamburger", "Fish Burger", "RS 200.00"));
        foods.add(new Food(R.drawable.pizza, "Pizza", "Chicken Pizza", "RS 350.00"));
        foods.add(new Food(R.drawable.humberger, "Hamburger", "Chicken Burger", "RS 300.00"));
        foods.add(new Food(R.drawable.humberger, "Hamburger", "Beef Burger", "RS 350.00"));
        foods.add(new Food(R.drawable.pizza, "Pizza", "Chicken Pizza", "RS 200.00"));
        foods.add(new Food(R.drawable.humberger, "Hamburger", "Chicken Burger", "RS 150.00"));
    }
}