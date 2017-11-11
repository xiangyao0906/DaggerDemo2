package com.lettle.xiangyao.daggerdemo2.presenter;

import com.lettle.xiangyao.daggerdemo2.api.Api;
import com.lettle.xiangyao.daggerdemo2.contract.MainContract;
import com.lettle.xiangyao.littledemo.bean.Movie;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiangyao on 2017/11/11.
 */

public class MainPresenter implements MainContract.Presenter {
    private Api api;
    private MainContract.View view;

    @Inject
    public MainPresenter(Api api, MainContract.View view) {
        this.api = api;
        this.view = view;
    }

    public void getMovies(String start, String count) {


        api.getMovie(start, count).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());

                    }

                    @Override
                    public void onNext(Movie movie) {
                        view.showLocationInfo(movie);

                    }
                })
        ;


    }
}
