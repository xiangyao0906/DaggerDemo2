package com.lettle.xiangyao.daggerdemo2.conpont;

import com.lettle.xiangyao.daggerdemo2.annotation.ActivityScope;
import com.lettle.xiangyao.daggerdemo2.model.MainModel;
import com.lettle.xiangyao.daggerdemo2.ui.MainActivity;

import dagger.Subcomponent;

/**
 * Created by xiangyao on 2017/11/11.
 */

@ActivityScope
@Subcomponent(modules = {MainModel.class})
public interface MainConpont {
    void inject(MainActivity mainActivity);
}
