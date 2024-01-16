package pe.isi.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;

    private String[] contacts;

    private void initViews() {
        lvContact = findViewById(R.id.lvContact);
    }

    private void loadContacts() {
        contacts = new String[]{"Carlos", "Joaquina", "Marcos", "Adriana"};
    }

    private void setupAdapter() {
        ArrayAdapter<String> contactAdapter;
        contactAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        lvContact.setAdapter(contactAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadContacts();
        setupAdapter();

    }
}