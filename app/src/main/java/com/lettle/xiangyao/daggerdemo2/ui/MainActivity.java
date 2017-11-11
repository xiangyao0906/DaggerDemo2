package com.lettle.xiangyao.daggerdemo2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lettle.xiangyao.daggerdemo2.R;
import com.lettle.xiangyao.daggerdemo2.application.DemoApplication;
import com.lettle.xiangyao.daggerdemo2.contract.MainContract;
import com.lettle.xiangyao.daggerdemo2.model.MainModel;
import com.lettle.xiangyao.daggerdemo2.presenter.MainPresenter;
import com.lettle.xiangyao.littledemo.bean.Movie;
import com.xiangyao.train.adapter.MovieAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xiangyao
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {
    @Inject
    MainPresenter mainPresenter;
    @BindView(R.id.movie_recyvleview)
    RecyclerView movieRecyvleview;

    private MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupActivityComponent();
        mainPresenter.getMovies("0", "0");

    }

    private void setupActivityComponent() {
        DemoApplication.get(this).getAppComponent().addSub(new MainModel(this)).inject(this);
    }

    @Override
    public void showLocationInfo(Movie movie) {

        movieAdapter = new MovieAdapter(R.layout.lisview_item, movie.getSubjects());
        movieRecyvleview.setLayoutManager(new LinearLayoutManager(this));
        movieRecyvleview.setAdapter(movieAdapter);

    }

    @Override
    public void showError(String message) {
    }
}
