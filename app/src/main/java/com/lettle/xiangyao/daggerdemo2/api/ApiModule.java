package com.lettle.xiangyao.daggerdemo2.api;

import com.lettle.xiangyao.daggerdemo2.annotation.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author xiangyao
 * @date 2017/11/11
 */
@ActivityScope
@Module
public class ApiModule {


    @Singleton
    @Provides
    public Api getApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Api.class);
    }

}
