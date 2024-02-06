package pe.isil.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class ProductActivity extends AppCompatActivity {

    private TextInputEditText etName, etQuantity;
    private Spinner spBrand;

    private void initViews() {
        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);
        spBrand = findViewById(R.id.spBrand);
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.brands_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBrand.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initViews();
        setupSpinner();
    }
}