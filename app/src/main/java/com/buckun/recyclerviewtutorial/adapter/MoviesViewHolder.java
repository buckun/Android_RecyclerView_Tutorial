package com.buckun.recyclerviewtutorial.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.buckun.recyclerviewtutorial.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesViewHolder extends RecyclerView.ViewHolder {


    TextView textTitle;
    TextView textViewLanguage;
    TextView textViewType;
    TextView textViewRating;
    TextView textViewLikePercent;
    TextView textViewVotesCount;
    TextView textViewIsNew;
    ImageView imageView;


    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textViewTitle);
        textViewLanguage = itemView.findViewById(R.id.textViewLanguage);
        textViewType = itemView.findViewById(R.id.textViewType);
        textViewRating = itemView.findViewById(R.id.textViewRating);
        textViewLikePercent = itemView.findViewById(R.id.textViewLikePercent);
        textViewVotesCount = itemView.findViewById(R.id.textViewVotesCount);
        textViewIsNew = itemView.findViewById(R.id.textViewIsNew);
        imageView = itemView.findViewById(R.id.imageView);
    }


}
