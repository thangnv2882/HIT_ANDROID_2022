package com.hitandroid.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context mContext;
    private List<Food> mFoodList;

    public FoodAdapter(Context mContext, List<Food> mFoodList) {
        this.mContext = mContext;
        this.mFoodList = mFoodList;
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        position = holder.getAdapterPosition();
        Food food = mFoodList.get(position);
        if(food == null) {
            return;
        }
        holder.foodImg.setImageResource(food.getFoodImg());
        holder.foodName.setText(food.getFoodName());
        holder.foodMore.setText(food.getFoodMore());
        holder.foodPrice.setText(food.getFoodPrice());
    }

    @Override
    public int getItemCount() {
        if(mFoodList != null) {
            return mFoodList.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        private ImageView foodImg;
        private TextView foodName, foodMore, foodPrice;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImg = itemView.findViewById(R.id.food_img);
            foodName = itemView.findViewById(R.id.food_name);
            foodMore = itemView.findViewById(R.id.food_more);
            foodPrice = itemView.findViewById(R.id.food_price);
        }
    }



}
