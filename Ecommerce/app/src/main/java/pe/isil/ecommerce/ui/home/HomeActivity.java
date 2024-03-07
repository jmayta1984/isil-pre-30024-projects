package pe.isil.ecommerce.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import pe.isil.ecommerce.R;
import pe.isil.ecommerce.data.model.Product;
import pe.isil.ecommerce.repositories.ProductRepository;
import pe.isil.ecommerce.ui.product.ProductActivity;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvProductList;
    private ProductAdapter productAdapter;
    private List<Product> products = new ArrayList<>();

    private ProductRepository repository ;


    private void initViews() {
        rvProductList = findViewById(R.id.rvProductList);
    }

    private void setupRepository() {
        repository = new ProductRepository();
        repository.setShowProductsInterface(products -> {
            HomeActivity.this.products = products;
            productAdapter.setProducts(products);
            productAdapter.notifyDataSetChanged();
        });

    }

    private void loadData() {
        repository.getAll();
    }

    private void setupRecyclerView() {
        productAdapter = new ProductAdapter(products);
        productAdapter.setOnClickListener(product -> {
          Intent intent = new Intent(HomeActivity.this, ProductActivity.class);
          intent.putExtra("id",product.getId());
          startActivity(intent);

        });
        rvProductList.setAdapter(productAdapter);
        rvProductList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupRepository();
        loadData();
        setupRecyclerView();
    }
}