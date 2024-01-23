package pe.isi.agenda;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ContactPrototype extends RecyclerView.ViewHolder {

    private ImageView ivPhoto;
    private TextView tvName, tvPhone;
    private CardView cvContact;

    private Contact contact;

    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";

    private void initViews() {
        ivPhoto = itemView.findViewById(R.id.ivPhoto);
        tvName = itemView.findViewById(R.id.tvName);
        tvPhone = itemView.findViewById(R.id.tvPhone);
        cvContact = itemView.findViewById(R.id.cvContact);
    }

    private void initViewListeners() {
        cvContact.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ContactActivity.class);
            intent.putExtra(KEY_NAME, contact.getName());
            intent.putExtra(KEY_PHONE, contact.getPhone());
            intent.putExtra(KEY_EMAIL, contact.getEmail());
            view.getContext().startActivity(intent);
        });
    }

    public ContactPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
        initViewListeners();
    }

    public void bindTo(Contact contact) {
        this.contact = contact;
        tvName.setText(this.contact.getName());
        tvPhone.setText(this.contact.getPhone());
    }
}
