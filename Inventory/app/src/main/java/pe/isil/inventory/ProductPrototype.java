package pe.isil.inventory;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductPrototype extends RecyclerView.ViewHolder {
    private TextView tvName, tvBrand, tvQuantity;
    private Product product;


    public void bindTo(Product product) {
        this.product = product;
        tvName.setText(product.getName());
        tvBrand.setText(product.getBrand());
        tvQuantity.setText(String.valueOf(product.getStock()));
    }

    private void initViews() {
        tvName = itemView.findViewById(R.id.tvName);
        tvBrand = itemView.findViewById(R.id.tvBrand);
        tvQuantity = itemView.findViewById(R.id.tvQuantity);
    }

    public ProductPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
    }
}
