package com.lettle.xiangyao.daggerdemo2.api;

import com.lettle.xiangyao.littledemo.bean.Movie;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xiangyao on 2017/11/11.
 */

public interface Api {
    String BASEURL = "https://api.douban.com/";

    /**
     * 获取电影
     */
    @GET("v2/movie/top250?")
    Observable<Movie> getMovie(@Query("start") String star, @Query("count") String count);


}
