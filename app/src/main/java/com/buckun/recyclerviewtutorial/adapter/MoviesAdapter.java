package com.buckun.recyclerviewtutorial.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buckun.recyclerviewtutorial.R;
import com.buckun.recyclerviewtutorial.model.Movie;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private ArrayList<Movie> movies;

    public MoviesAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoviesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.textTitle.setText(movie.getTitle());
        holder.textViewLanguage.setText(movie.getLanguage());
        holder.textViewType.setText(movie.getType());
        holder.textViewRating.setText(movie.getType());
        holder.textViewLikePercent.setText(movie.getLikePercent() + "%");
        holder.textViewVotesCount.setText(movie.getVoteCount() + " votes");

        if (movie.isNewMovie() == 1) {
            holder.textViewIsNew.setVisibility(View.VISIBLE);
        } else {
            holder.textViewIsNew.setVisibility(View.INVISIBLE);
        }

        Glide.with(holder.itemView).load(movie.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
