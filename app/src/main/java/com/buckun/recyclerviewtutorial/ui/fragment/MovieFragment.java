package com.buckun.recyclerviewtutorial.ui.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.buckun.recyclerviewtutorial.R;
import com.buckun.recyclerviewtutorial.adapter.MoviesAdapter;
import com.buckun.recyclerviewtutorial.apiInterface.MovieApi;
import com.buckun.recyclerviewtutorial.model.Movie;
import com.buckun.recyclerviewtutorial.rest.RetrofitClientInstance;
import com.buckun.recyclerviewtutorial.ui.activity.MainActivity;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    ArrayList<Movie> movies;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;


    private MovieViewModel mViewModel;

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        init();
        swipeRefreshLayout.setRefreshing(true);
        fetchMovie();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchMovie();
            }
        });
    }

    private void init() {
        swipeRefreshLayout = getView().findViewById(R.id.swipe_RefreshLayout);
        recyclerView = getView().findViewById(R.id.recycler_view);
    }

    /**
     * Create handle for the RetrofitInstance interface
     */
    private void fetchMovie() {
        MovieApi service = RetrofitClientInstance.getRetrofitInstance().create(MovieApi.class);
        Call<ArrayList<Movie>> call = service.getAllMovies();
        call.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
                movies = response.body();
                generateDataList(movies);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Method to generate List of data using RecyclerView with custom adapter
     */
    private void generateDataList(ArrayList<Movie> movieList) {
        MoviesAdapter adapter = new MoviesAdapter(movieList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

}
