package com.hitandroid.api_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvFood;
    private FoodAdapter foodAdapter;
    private List<Foods> foods = new ArrayList<>();
    private static String url = "https://appnote-codernon.herokuapp.com/api/monan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvFood = findViewById(R.id.rcv_food);

        getData();
    }

    public void getData() {

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Foods food = new Foods();
                        food.setMonanId(jsonObject.getInt("monanId"));
                        food.setMonanname(jsonObject.getString("moanname").toString());
                        food.setAvt(jsonObject.getString("avt").toString());
                        food.setNguyenlieu(jsonObject.getString("nguyenlieu").toString());
                        food.setCongthuc(jsonObject.getString("congthuc").toString());
                        food.setTien(jsonObject.getString("tien").toString());

                        foods.add(food);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    foodAdapter = new FoodAdapter(getApplicationContext(), foods);
                    rcvFood.setAdapter(foodAdapter);
                    rcvFood.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "No data", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}