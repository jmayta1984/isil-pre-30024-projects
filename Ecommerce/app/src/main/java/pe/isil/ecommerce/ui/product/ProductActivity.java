package pe.isil.ecommerce.ui.product;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;

import pe.isil.ecommerce.R;
import pe.isil.ecommerce.data.local.ProductEntity;
import pe.isil.ecommerce.data.model.Product;
import pe.isil.ecommerce.repositories.ProductRepository;

public class ProductActivity extends AppCompatActivity {

    private ImageView ivPoster;
    private TextView tvName, tvPrice, tvDescription;
    private Button btAdd;
    private ProductRepository repository;
    private Product product;

    private void initViews() {
        ivPoster = findViewById(R.id.ivPoster);
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvDescription = findViewById(R.id.tvDescription);
        btAdd = findViewById(R.id.btAdd);
    }



    private void initVieListeners() {
        btAdd.setOnClickListener(view -> {
            repository.add(product);
        });
    }

    private void loadData() {
        repository.getById(getIntent().getIntExtra("id",0));
    }

    private void setupRepository() {
        repository = new ProductRepository();
        repository.setShowProductInterface(product -> {
            ProductActivity.this.product = product;
            tvName.setText(product.getName());
            tvPrice.setText(String.valueOf(product.getPrice()));
            tvDescription.setText(product.getDescription());
            Glide.with(this).load(product.getUrlImage()).into(ivPoster);

        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initViews();
        initVieListeners();
        setupRepository();
        loadData();
     }
}