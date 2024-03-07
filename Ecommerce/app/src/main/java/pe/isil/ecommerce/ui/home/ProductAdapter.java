package pe.isil.ecommerce.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.isil.ecommerce.R;
import pe.isil.ecommerce.data.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductPrototype> {

    private List<Product> products;

    private OnClickListener onClickListener;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ProductPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_product, parent, false);
        return new ProductPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductPrototype prototype, int position) {
        prototype.bindTo(products.get(position));
        prototype.itemView.setOnClickListener(view -> {
            onClickListener.onClick(products.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public interface OnClickListener {
        public void onClick(Product product);
    }
}
