package pe.isi.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Fragment fragment = new TaskListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flBody, fragment).commit();
    }
}