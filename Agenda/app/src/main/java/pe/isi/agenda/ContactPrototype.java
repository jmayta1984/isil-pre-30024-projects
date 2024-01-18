package pe.isi.agenda;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactPrototype extends RecyclerView.ViewHolder {

    private ImageView ivPhoto;
    private TextView tvName, tvPhone;

    private void initViews() {
        ivPhoto = itemView.findViewById(R.id.ivPhoto);
        tvName = itemView.findViewById(R.id.tvName);
        tvPhone = itemView.findViewById(R.id.tvPhone);
    }

    public ContactPrototype(@NonNull View itemView) {
        super(itemView);

        initViews();
    }

    public void bindTo(Contact contact) {
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());
    }
}
