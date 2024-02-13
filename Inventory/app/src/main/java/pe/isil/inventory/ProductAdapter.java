package pe.isil.inventory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductPrototype> {

    private  List<Product> products;

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
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

        Product  product = products.get(position);
        prototype.bindTo(product);
        prototype.itemView.setOnClickListener(view -> {
            if (onClickListener != null){
                onClickListener.onClick(position, product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public interface OnClickListener {
        public void onClick(int position, Product product);
    }
}
