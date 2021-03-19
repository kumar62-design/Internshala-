package com.example.movieproject.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject.R;
import com.example.movieproject.adapter.CommentAdapter;
import com.example.movieproject.api.Client;
import com.example.movieproject.api.ServiceInterface;
import com.example.movieproject.model.Movie;
import com.example.movieproject.model.ResponseMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity {

    private RecyclerView commentRecycler;
    private LinearLayoutManager linearLayoutManager;
    private CommentAdapter adapter;
    private List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


        commentRecycler = (RecyclerView) findViewById(R.id.commentRecycler);
        linearLayoutManager = new LinearLayoutManager(this);
        commentRecycler.setHasFixedSize(true);
        commentRecycler.setLayoutManager(linearLayoutManager);

        ServiceInterface service = Client.getInstans().create(ServiceInterface.class);


        Call<ResponseMovie> call = service.getComment();
        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                movies = response.body().getData();
                adapter = new CommentAdapter(movies,CommentActivity.this);
                commentRecycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {

            }
        });
    }
}