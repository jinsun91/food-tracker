package jspark.foodtracker;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Recognizer recognizer = new Recognizer();
        recognizer.recognizer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cameraButton = (Button) findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(i);
            }
        });
    }

}
