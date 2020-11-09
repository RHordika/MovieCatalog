package com.example.moviecatalog;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviecatalog.databinding.ItemMovieBinding;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    ItemMovieBinding itemMovieBinding;

    public MoviesViewHolder(ItemMovieBinding binding) {
        super(binding.getRoot());//get root obtiene la vista del binding
        itemMovieBinding = binding;
    }

    public void decorateWith(Movie model) {
        Glide.with(itemView.getContext()).load(model.getPoster()).into(itemMovieBinding.ivPoster);
        itemView.getContext().getString(R.string.app_name);
        itemMovieBinding.title.setText(model.getTittle());
    }



}
