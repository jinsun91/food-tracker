package jspark.foodtracker;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.File;
import java.time.LocalDateTime;
import java.text.DateFormatSymbols;

public class FoodItem {
    private String foodName;
    private LocalDateTime cautionDate;
    private boolean isExpiry;
    private File photo;
    public FoodItem(String foodName, LocalDateTime cautionDate, File photo){
        this(foodName, cautionDate, photo, true);
    }

    public FoodItem(String foodName, LocalDateTime cautionDate, File photo, boolean isExpiry){
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
