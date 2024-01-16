package pe.isi.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    private RecyclerView rvContacts;

    private ArrayList<Contact> contacts;

    private void initViews() {
        rvContacts = findViewById(R.id.rvContacts);
    }

    private void loadContacts() {
        contacts = new ArrayList<>();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        initViews();
        loadContacts();
    }
}