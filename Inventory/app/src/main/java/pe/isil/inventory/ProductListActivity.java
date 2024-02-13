package pe.isil.inventory;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;

public class ProductListActivity extends AppCompatActivity {

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_STOCK = "stock";
    private static final String KEY_UPDATE = "update";

    private int position;

    private FloatingActionButton faAdd;
    private RecyclerView rvProductList;
    private ProductAdapter adapter;
    private List<Product> products;
    private ActivityResultLauncher<Intent> launcherNew, launcherDelete;

    private void registerLauncher() {
        launcherNew = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        loadData();
                        adapter.setProducts(products);
                        adapter.notifyItemInserted(products.size() - 1);
                    }
                });

        launcherDelete = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        loadData();
                        adapter.setProducts(products);

                        int update = Objects.requireNonNull(result.getData()).getIntExtra(KEY_UPDATE, 0);

                        if (update == 0) {

                            adapter.notifyItemRemoved(position);

                        } else {
                            adapter.notifyItemChanged(position);
                        }


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
            launcherNew.launch(intent);
        });


    }

    private void loadData() {
        products = AppDatabase.getInstance(this).productDao().getAll();
    }

    private void setupAdapter() {
        adapter = new ProductAdapter(products);
        rvProductList.setLayoutManager(new LinearLayoutManager(this));
        rvProductList.setAdapter(adapter);

        adapter.setOnClickListener((position, product) -> {
            Intent intent = new Intent(ProductListActivity.this, ProductActivity.class);
            intent.putExtra(KEY_ID, product.getId());
            intent.putExtra(KEY_NAME, product.getName());
            intent.putExtra(KEY_BRAND, product.getBrand());
            intent.putExtra(KEY_STOCK, product.getStock());
            this.position = position;
            launcherDelete.launch(intent);
        });
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