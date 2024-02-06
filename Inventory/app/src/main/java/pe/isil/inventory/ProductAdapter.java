package pe.isil.inventory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductPrototype> {

    private final List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
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
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
