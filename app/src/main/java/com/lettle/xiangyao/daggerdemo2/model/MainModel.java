package com.lettle.xiangyao.daggerdemo2.model;

import com.lettle.xiangyao.daggerdemo2.annotation.ActivityScope;
import com.lettle.xiangyao.daggerdemo2.contract.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author xiangyao
 * @date 2017/11/11
 */

@Module
public class MainModel {
    private MainContract.View view;

    public MainModel(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContract.View providerView() {
        return view;
    }

}
