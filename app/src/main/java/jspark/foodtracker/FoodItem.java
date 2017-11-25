package com.example.mac.foodtracker;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;

public class FoodItem {
    private String foodName;
    private LocalDateTime cautionDate;
    private boolean isExpiry;
    //TODO: Pic representation

    public FoodItem(String foodName, LocalDateTime cautionDate){
        this(foodName, cautionDate, true);
    }

    public FoodItem(String foodName, LocalDateTime cautionDate, boolean isExpiry){
        this.foodName = foodName;
        this.cautionDate = cautionDate;
        this.isExpiry = isExpiry;
    }

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(foodName).append("\t\t");
        if(isExpiry){
            sb.append("Expires: ");
        } else{
            sb.append("Best Before: ");
        }

        sb.append(cautionDate.getDayOfMonth()).append(" ").
                append(getMonth(cautionDate.getMonth().getValue())).append(" ").
                append(cautionDate.getYear());
        return sb.toString();
    }

}
