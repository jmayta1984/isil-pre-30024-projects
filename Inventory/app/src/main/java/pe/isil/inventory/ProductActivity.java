package pe.isil.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ProductActivity extends AppCompatActivity {

    private TextInputEditText etName, etQuantity;
    private Spinner spBrand;
    private FloatingActionButton faSave;
    private Button btDelete;

    private String brand;

    private Product product;

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_STOCK = "stock";
    private static final String KEY_UPDATE = "update";


    private void initViews() {
        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);
        spBrand = findViewById(R.id.spBrand);
        faSave = findViewById(R.id.faSave);
        btDelete = findViewById(R.id.btDelete);
    }

    private void initViewListeners() {
        spBrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] brands = getResources().getStringArray(R.array.brands_array);
                brand = brands[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        faSave.setOnClickListener(view -> {
            String name = Objects.requireNonNull(etName.getText()).toString();
            int stock = Integer.parseInt(Objects.requireNonNull(etQuantity.getText()).toString());
            Intent intent = new Intent(ProductActivity.this, ProductListActivity.class);

            if (product.getId() != 0) {
                product.setName(name);
                product.setBrand(brand);
                product.setStock(stock);
                intent.putExtra(KEY_UPDATE, 1);
                setResult(RESULT_OK, intent);
                AppDatabase.getInstance(ProductActivity.this).productDao().update(product);

            } else {
                product = new Product();
                product.setName(name);
                product.setBrand(brand);
                product.setStock(stock);
                intent.putExtra(KEY_UPDATE, 0);
                setResult(RESULT_OK, intent);
                AppDatabase.getInstance(ProductActivity.this).productDao().insert(product);
            }
            finish();
        });

        btDelete.setOnClickListener(view -> {
            Intent intent = new Intent(ProductActivity.this, ProductListActivity.class);
            setResult(RESULT_OK, intent);
            AppDatabase.getInstance(ProductActivity.this).productDao().delete(product);
            finish();
        });
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.brands_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBrand.setAdapter(adapter);
    }

    private void loadProduct() {
        Intent intent = getIntent();
        product = new Product();
        product.setId(intent.getIntExtra(KEY_ID, 0));
        product.setName(intent.getStringExtra(KEY_NAME));
        product.setBrand(intent.getStringExtra(KEY_BRAND));
        product.setStock(intent.getIntExtra(KEY_STOCK, 0));

        etName.setText(product.getName());
        etQuantity.setText(String.valueOf(product.getStock()));

        String[] brands = getResources().getStringArray(R.array.brands_array);

        spBrand.setSelection(new ArrayList<>(Arrays.asList(brands)).indexOf(product.getBrand()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initViews();
        initViewListeners();
        setupSpinner();
        loadProduct();
    }
}