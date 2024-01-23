package pe.isi.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class ContactActivity extends AppCompatActivity {

    private FloatingActionButton faSave;

    private TextInputEditText etName, etPhone, etEmail;

    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";

    private void initViews() {
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        faSave = findViewById(R.id.faSave);
    }

    private void initViewListeners() {
        faSave.setOnClickListener(view -> {
            Intent intent = new Intent(ContactActivity.this, ContactsActivity.class);
            intent.putExtra(KEY_NAME, Objects.requireNonNull(etName.getText()).toString());
            intent.putExtra(KEY_PHONE, Objects.requireNonNull(etPhone.getText()).toString());
            intent.putExtra(KEY_EMAIL, Objects.requireNonNull(etEmail.getText()).toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void loadContact() {
        Intent intent = getIntent();
        etName.setText(intent.getStringExtra(KEY_NAME));
        etPhone.setText(intent.getStringExtra(KEY_PHONE));
        etEmail.setText(intent.getStringExtra(KEY_EMAIL));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initViews();
        initViewListeners();
        loadContact();
    }


}