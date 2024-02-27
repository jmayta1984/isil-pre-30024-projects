package pe.isil.meals;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CategoryPrototype extends RecyclerView.ViewHolder {

    private ImageView ivCategoryImage;
    private TextView tvCategoryName;

    private void initViews() {
        ivCategoryImage = itemView.findViewById(R.id.ivCategoryImage);
        tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
    }

    public void bindTo(@NonNull Category category) {
        Glide.with(itemView.getContext()).load(category.getUrlImage()).into(ivCategoryImage);
        tvCategoryName.setText(category.getName());
    }

    public CategoryPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
    }
}
