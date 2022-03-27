package com.hitandroid.api_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MoreForFood extends AppCompatActivity {

    ImageView back, imgMore;
    TextView title, resources, recipe, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_for_food);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }

        Foods foods = (Foods) bundle.get("food");
        imgMore = findViewById(R.id.img_more);
        title = findViewById(R.id.title);
        resources = findViewById(R.id.resources);
        recipe = findViewById(R.id.recipe);
        price = findViewById(R.id.price);
        back = findViewById(R.id.back);


        Picasso.get().load(foods.getAvt()).into(imgMore);
        title.setText(foods.getMonanname());
        resources.setText(foods.getNguyenlieu());
        recipe.setText(foods.getCongthuc());
        price.setText(foods.getTien());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreForFood.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}