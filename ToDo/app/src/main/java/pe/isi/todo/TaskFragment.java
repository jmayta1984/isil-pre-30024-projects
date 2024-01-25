package pe.isi.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;


public class TaskFragment extends Fragment {

    private Task task;
    private TextInputEditText etName;
    private CalendarView cvDate;
    private FloatingActionButton faSave;

    private void initViews() {
        etName = requireView().findViewById(R.id.etName);
        cvDate = requireView().findViewById(R.id.cvDate);
        faSave = requireView().findViewById(R.id.faSave);
    }

    private void initViewListeners() {
        faSave.setOnClickListener(view -> {
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        task = new Task();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initViewListeners();
    }
}
