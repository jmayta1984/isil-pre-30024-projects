package pe.isil.meals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryPrototype> {
    private List<Category> categories;

    public OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }


    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_category, parent, false);
        return new CategoryPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryPrototype prototype, int position) {
        prototype.bindTo(categories.get(position));
        prototype.itemView.setOnClickListener(view -> {
            onClickListener.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public interface OnClickListener {
        void onClick(int position);
    }
}
