package com.lettle.xiangyao.daggerdemo2.application;

import android.app.Application;
import android.content.Context;

import com.lettle.xiangyao.daggerdemo2.api.ApiModule;
import com.lettle.xiangyao.daggerdemo2.conpont.AppConpont;
import com.lettle.xiangyao.daggerdemo2.conpont.DaggerAppConpont;
import com.lettle.xiangyao.daggerdemo2.module.ApplictionModule;

/**
 *
 * @author xiangyao
 * @date 2017/11/11
 */

public class DemoApplication extends Application {


    private AppConpont appComponent;


    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppConpont.builder().apiModule(new ApiModule()).applictionModule(new ApplictionModule(this)).build();
    }

    public AppConpont getAppComponent() {
        return appComponent;
    }
}
