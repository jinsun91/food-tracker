package jspark.foodtracker;

import android.annotation.TargetApi;
import android.os.Build;

import java.time.LocalDateTime;
import java.text.DateFormatSymbols;

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
    @TargetApi(Build.VERSION_CODES.O)
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
