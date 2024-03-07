package pe.isil.ecommerce.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import pe.isil.ecommerce.R;
import pe.isil.ecommerce.data.model.Product;

public class ProductPrototype extends RecyclerView.ViewHolder {

    private ImageView ivPoster;
    private TextView tvName;

    private void initViews() {
        ivPoster = itemView.findViewById(R.id.ivPoster);
        tvName = itemView.findViewById(R.id.tvName);
    }

    public ProductPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    public void bindTo(Product product) {

        tvName.setText(product.getName());
        Glide.with(itemView.getContext()).load(product.getUrlImage()).into(ivPoster);
    }
}
