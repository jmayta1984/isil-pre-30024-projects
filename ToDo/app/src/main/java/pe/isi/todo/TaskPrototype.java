package pe.isi.todo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskPrototype extends RecyclerView.ViewHolder {

    private TextView tvName, tvDate;
    private Task task;

    private void initViews() {
        tvName = itemView.findViewById(R.id.tvName);
        tvDate = itemView.findViewById(R.id.tvDate);
    }

    public TaskPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    public void bindTo(Task task) {
        this.task = task;
        tvName.setText(this.task.getTitle());
        tvDate.setText(this.task.getDate().toString());

    }
}
