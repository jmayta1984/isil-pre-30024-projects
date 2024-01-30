package pe.isi.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class TaskActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Fragment fragment = new TaskFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flBody, fragment).commit();
    }

}