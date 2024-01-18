package pe.isi.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    private RecyclerView rvContacts;

    private FloatingActionButton faAdd;

    private ArrayList<Contact> contacts;

    private static final int REQUEST_CODE = 1;


    private void initViews() {
        rvContacts = findViewById(R.id.rvContacts);
        faAdd = findViewById(R.id.faAdd);
    }

    private void initViewListeners() {
        faAdd.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
            startActivityIfNeeded(intent, 1);
        });
    }

    private void loadContacts() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Luis Zapata", "987645132", "lzapata@gmail.com"));
        contacts.add(new Contact("Pedro Campos", "965841712", "pcampos@gmail.com"));
    }

    private void setupAdapter() {
        ContactAdapter contactAdapter;
        contactAdapter = new ContactAdapter(contacts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvContacts.setLayoutManager(layoutManager);
        rvContacts.setAdapter(contactAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        initViews();
        initViewListeners();
        loadContacts();
        setupAdapter();
    }
}