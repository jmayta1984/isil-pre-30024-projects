package pe.isi.agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactPrototype> {

    ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_contact, parent, false);
        return new ContactPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactPrototype prototype, int position) {
        prototype.bindTo(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
