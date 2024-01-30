package pe.isi.todo;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;

public class TaskListFragment extends Fragment {

    private ArrayList<Task> tasks;

    private RecyclerView rvTaskList;
    private FloatingActionButton faAdd;

    private TaskAdapter taskAdapter;

    private ActivityResultLauncher<Intent> launcher;

    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";


    private void registerLauncher() {
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            String name = intent.getStringExtra(KEY_NAME);
                            long date = intent.getLongExtra(KEY_DATE, 0);
                            Task task = new Task();
                            task.setTitle(name);
                            task.setDate(new Date(date));
                            tasks.add(task);
                            taskAdapter.notifyItemChanged(tasks.size() - 1);
                        }
                    }
                });
    }

    private void initViews() {
        rvTaskList = requireView().findViewById(R.id.rvTaskList);
        faAdd = requireView().findViewById(R.id.faAdd);
    }

    private void initViewListeners() {
        faAdd.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), TaskActivity.class);
            launcher.launch(intent);

        });
    }

    private void loadTasks() {
        tasks = new ArrayList<>();
    }

    private void setupAdapter() {
        taskAdapter = new TaskAdapter(tasks);
        rvTaskList.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvTaskList.setAdapter(taskAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerLauncher();
        initViews();
        initViewListeners();
        loadTasks();
        setupAdapter();

    }
}
