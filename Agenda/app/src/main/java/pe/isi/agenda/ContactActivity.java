package pe.isi.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactActivity extends AppCompatActivity {

    private FloatingActionButton faSave;

    private void initViews() {
        faSave = findViewById(R.id.faSave);
    }

    private void initViewListeners() {
        faSave.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initViews();
        initViewListeners();
    }


}