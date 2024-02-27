package pe.isil.meals;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MealPrototype extends RecyclerView.ViewHolder {

    private ImageView ivMealImage;
    private TextView tvMealName;

    private void initViews() {
        ivMealImage = itemView.findViewById(R.id.ivMealImage);
        tvMealName = itemView.findViewById(R.id.tvMealName);
    }

    public void bindTo(@NonNull Meal meal) {
        Glide.with(itemView.getContext()).load(meal.getUrlImage()).into(ivMealImage);
        tvMealName.setText(meal.getName());
    }

    public MealPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
    }



}
