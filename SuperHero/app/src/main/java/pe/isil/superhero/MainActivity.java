package pe.isil.superhero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etHeroName;
    private Button btSearchHero;
    private RecyclerView rvHeroList;
    private HeroAdapter adapter;

    private ArrayList<Hero> heroes = new ArrayList<>();

    private void initViews() {
        etHeroName = findViewById(R.id.etHeroName);
        btSearchHero = findViewById(R.id.btSearchHero);
        rvHeroList = findViewById(R.id.rvHeroList);
    }

    private void initViewListeners() {
        btSearchHero.setOnClickListener(view -> {
        });
    }


    private void setupRecyclerView() {
        adapter = new HeroAdapter(heroes);
        rvHeroList.setAdapter(adapter);
        rvHeroList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewListeners();
        setupRecyclerView();
    }
}