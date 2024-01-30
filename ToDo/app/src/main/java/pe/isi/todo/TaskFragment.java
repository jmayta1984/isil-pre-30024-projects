package pe.isi.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Objects;


public class TaskFragment extends Fragment {

    private Task task;
    private TextInputEditText etName;
    private CalendarView cvDate;
    private FloatingActionButton faSave;

    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";

    private void initViews() {
        etName = requireView().findViewById(R.id.etName);
        cvDate = requireView().findViewById(R.id.cvDate);
        faSave = requireView().findViewById(R.id.faSave);
    }

    private void initViewListeners() {
        faSave.setOnClickListener(view -> {
            Intent intent = new Intent(requireActivity(), TaskListActivity.class);
            String name = Objects.requireNonNull(etName.getText()).toString();
            long date = cvDate.getDate();
            intent.putExtra(KEY_NAME, name);
            intent.putExtra(KEY_DATE, date);
            requireActivity().setResult(Activity.RESULT_OK, intent);
            requireActivity().finish();
        });

        cvDate.setOnDateChangeListener((calendarView, year, month, dayOfMonth) -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth);
            calendarView.setDate(calendar.getTimeInMillis());
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
