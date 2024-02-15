package pe.isil.superhero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroPrototype> {

    private ArrayList<Hero> heroes;

    public HeroAdapter(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_hero, parent, false);
        return new HeroPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroPrototype prototype, int position) {
        prototype.bindTo(heroes.get(position));
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }
}
