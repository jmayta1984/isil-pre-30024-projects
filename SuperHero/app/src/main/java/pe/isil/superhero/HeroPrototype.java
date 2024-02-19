package pe.isil.superhero;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class HeroPrototype extends RecyclerView.ViewHolder {

    private ImageView ivHeroImage;
    private TextView tvHeroName, tvHeroFullName;

    private void initViews() {
        ivHeroImage = itemView.findViewById(R.id.ivHeroImage);
        tvHeroName = itemView.findViewById(R.id.tvHeroName);
        tvHeroFullName = itemView.findViewById(R.id.tvHeroFullName);
    }

    public HeroPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    public void bindTo(Hero hero) {

        tvHeroName.setText(hero.getName());
        tvHeroFullName.setText(hero.getFullName());
        Glide.with(itemView.getContext()).load(hero.getUrl()).into(ivHeroImage);
    }
}
