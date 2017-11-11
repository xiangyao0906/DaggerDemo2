package com.lettle.xiangyao.daggerdemo2.conpont;

import android.app.Application;

import com.lettle.xiangyao.daggerdemo2.annotation.ActivityScope;
import com.lettle.xiangyao.daggerdemo2.api.Api;
import com.lettle.xiangyao.daggerdemo2.api.ApiModule;
import com.lettle.xiangyao.daggerdemo2.application.DemoApplication;
import com.lettle.xiangyao.daggerdemo2.model.MainModel;
import com.lettle.xiangyao.daggerdemo2.module.ApplictionModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author xiangyao
 * @date 2017/11/11
 */


@Singleton
@Component(modules = {ApiModule.class, ApplictionModule.class})
public interface AppConpont {

    MainConpont addSub(MainModel mainConpont);


    /**
     * 获取appliction
     */
    DemoApplication getDemoApplication();

    /**
     *
     *
     * */
    Api getApi();




}
