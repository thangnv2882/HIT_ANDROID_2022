package com.hitandroid.api_food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context mContext;
    private List<Foods> mFoods;

    public FoodAdapter(Context mContext, List<Foods> mFoods) {
        this.mContext = mContext;
        this.mFoods = mFoods;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        Foods food = mFoods.get(position);
        position = holder.getAdapterPosition();
        if(food == null) {
            return;
        }
        Picasso.get().load(mFoods.get(position).getAvt()).into(holder.foodImg);
        holder.foodName.setText(mFoods.get(position).getMonanname());
        holder.foodPrice.setText(mFoods.get(position).getTien());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewMoreForFood(food);
            }
        });
    }

    private void ViewMoreForFood(Foods food) {
        Intent intent = new Intent(mContext, MoreForFood.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("food", food);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mFoods != null) {
            return mFoods.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView foodImg;
        private TextView foodName, foodPrice;
        LinearLayout item;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImg = itemView.findViewById(R.id.food_img);
            foodName = itemView.findViewById(R.id.food_name);
            foodPrice = itemView.findViewById(R.id.food_price);
            item = itemView.findViewById(R.id.item);
        }
    }
}
