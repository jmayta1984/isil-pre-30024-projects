package pe.isi.agenda;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

    private ContactAdapter contactAdapter;

    private ActivityResultLauncher<Intent> launcher;

    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";

    private void registerLauncher() {
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            String name = intent.getStringExtra(KEY_NAME);
                            String phone = intent.getStringExtra(KEY_PHONE);
                            String email = intent.getStringExtra(KEY_EMAIL);
                            Contact contact = new Contact(name, phone, email);
                            contacts.add(contact);
                            contactAdapter.notifyItemInserted(contacts.size() - 1);
                        }
                    }
                });
    }

    private void initViews() {
        rvContacts = findViewById(R.id.rvContacts);
        faAdd = findViewById(R.id.faAdd);
    }

    private void initViewListeners() {
        faAdd.setOnClickListener(view -> {
            Intent intent = new Intent(ContactsActivity.this, ContactActivity.class);
            launcher.launch(intent);
        });
    }

    private void loadContacts() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Luis Zapata", "987645132", "lzapata@gmail.com"));
        contacts.add(new Contact("Pedro Campos", "965841712", "pcampos@gmail.com"));
    }

    private void setupAdapter() {
        contactAdapter = new ContactAdapter(contacts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvContacts.setLayoutManager(layoutManager);
        rvContacts.setAdapter(contactAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        registerLauncher();
        initViews();
        initViewListeners();
        loadContacts();
        setupAdapter();
    }
}