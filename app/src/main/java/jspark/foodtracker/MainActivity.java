package jspark.foodtracker;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView simpleList;
    public static final List<String> foodList = new ArrayList<>();
    private static BaseAdapter baseAdapter;

    @TargetApi(Build.VERSION_CODES.O)
      
    @Override   
  protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Recognizer recognizer = new Recognizer();
        recognizer.recognizer();
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = findViewById(R.id.simpleListView);
        baseAdapter = new ArrayAdapter<>(this, R.layout.activity_listview, R.id.textView, foodList);
        simpleList.setAdapter(baseAdapter);
        Button cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), CameraActivity.class);
            startActivity(i);
        });
    }
  
    public static void addFoodItem(FoodItem foodItem){
        foodList.add(foodItem.toString());
        baseAdapter.notifyDataSetInvalidated();
        System.out.println("ADDED");

    }

}
