package pe.isil.inventory;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private FloatingActionButton faAdd;
    private RecyclerView rvProductList;
    private ProductAdapter adapter;
    private List<Product> products;
    private ActivityResultLauncher<Intent> launcher;

    private void registerLauncher() {
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        loadData();
                        adapter.notifyItemChanged(products.size() - 1);
                    }
                });
    }

    private void initViews() {
        rvProductList = findViewById(R.id.rvProductList);
        faAdd = findViewById(R.id.faAdd);
    }

    private void initViewListeners() {
        faAdd.setOnClickListener(view -> {
            Intent intent = new Intent(ProductListActivity.this, ProductActivity.class);
            launcher.launch(intent);
        });
    }

    private void loadData() {
        products = AppDatabase.getInstance(this).productDao().getAll();
    }

    private void setupAdapter() {
        adapter = new ProductAdapter(products);
        rvProductList.setLayoutManager(new LinearLayoutManager(this));
        rvProductList.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        registerLauncher();
        initViews();
        initViewListeners();
        loadData();
        setupAdapter();
    }
}