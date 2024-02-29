package pe.isil.sensorssample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Accelerometer accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerometer = new Accelerometer(this);

        accelerometer.setListener((x, y, z) -> {
            if (x > 1.0f) {
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
            else if (x < -1.0f) {
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);

            }

        });
    }

    protected void onResume() {
        super.onResume();
        accelerometer.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        accelerometer.unregister();
    }
}