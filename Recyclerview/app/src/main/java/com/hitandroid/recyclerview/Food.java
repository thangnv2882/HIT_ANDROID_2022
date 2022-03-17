package com.hitandroid.recyclerview;

public class Food {
    private int foodImg;
    private String foodName;
    private String foodMore;
    private String foodPrice;

    public Food(int foodImg, String foodName, String foodMore, String foodPrice) {
        this.foodImg = foodImg;
        this.foodName = foodName;
        this.foodMore = foodMore;
        this.foodPrice = foodPrice;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg = foodImg;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodMore() {
        return foodMore;
    }

    public void setFoodMore(String foodMore) {
        this.foodMore = foodMore;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }
}
