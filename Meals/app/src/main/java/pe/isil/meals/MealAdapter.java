package pe.isil.meals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealPrototype> {
    private List<Meal> meals;

    public MealAdapter(List<Meal> meals) {
        this.meals = meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @NonNull
    @Override
    public MealPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_meal, parent, false);
        return new MealPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealPrototype prototype, int position) {
        prototype.bindTo(meals.get(position));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }


}
