package com.lettle.xiangyao.daggerdemo2.module;

import android.content.res.Resources;

import com.lettle.xiangyao.daggerdemo2.annotation.ActivityScope;
import com.lettle.xiangyao.daggerdemo2.application.DemoApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiangyao on 2017/11/11.
 */

@ActivityScope
@Module
public class ApplictionModule {

    private DemoApplication demoApplication;

    public ApplictionModule(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }

    @Singleton
    @Provides
    public DemoApplication getDemoApplication() {
        return demoApplication;
    }

    @Singleton
    @Provides
    public Resources getResources(DemoApplication demoApplication) {

        return demoApplication.getResources();
    }
}
