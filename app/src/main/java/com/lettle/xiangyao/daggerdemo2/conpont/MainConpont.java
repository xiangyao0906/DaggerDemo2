package com.lettle.xiangyao.daggerdemo2.conpont;

import com.lettle.xiangyao.daggerdemo2.annotation.ActivityScope;
import com.lettle.xiangyao.daggerdemo2.model.MainModel;
import com.lettle.xiangyao.daggerdemo2.ui.MainActivity;

import dagger.Subcomponent;

/**
 * @author xiangyao
 * @date 2017/11/11
 * <p>
 * 它是子Component，会完全继承父Component的所有依赖注入对象！
 */

@ActivityScope
@Subcomponent(modules = {MainModel.class})
public interface MainConpont {

    /**
     * 提供注入方法
     */
    void inject(MainActivity mainActivity);
}
