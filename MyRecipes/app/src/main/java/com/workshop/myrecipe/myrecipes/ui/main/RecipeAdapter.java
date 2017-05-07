package com.workshop.myrecipe.myrecipes.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.workshop.myrecipe.myrecipes.R;
import com.workshop.myrecipe.myrecipes.data.local.RecipeStore;
import com.workshop.myrecipe.myrecipes.data.model.Recipe;
import com.workshop.myrecipe.myrecipes.ui.recipe.RecipeActivity;

class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final RecipeStore store;

    public RecipeAdapter(RecipeStore store) {
        this.store = store;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false
        );
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipeViewHolder holder, int position) {
        final Recipe recipe = store.get(position);
        holder.textView.setText(recipe.getTitle());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.textView.getContext();
                Intent intent = new Intent(context, RecipeActivity.class);
                intent.putExtra("id", recipe.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return store.size();
    }
}
