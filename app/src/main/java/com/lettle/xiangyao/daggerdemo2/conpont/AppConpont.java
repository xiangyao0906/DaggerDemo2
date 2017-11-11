package com.lettle.xiangyao.daggerdemo2.conpont;

import com.lettle.xiangyao.daggerdemo2.api.ApiModule;
import com.lettle.xiangyao.daggerdemo2.model.MainModel;
import com.lettle.xiangyao.daggerdemo2.module.ApplictionModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author xiangyao
 * @date 2017/11/11
 * <p>
 * app级的Compont(主)
 * <p>
 * 依赖一些全局的对象
 * 网络访问框架/Application/SharePrefence 等等
 */


@Singleton
@Component(modules = {ApiModule.class, ApplictionModule.class})
public interface AppConpont {

    /**
     * 可以通过添加子Compont 的方式
     * 使其可以使用主Compont的依赖关系
     *
     * @link
     *
     */

    MainConpont addSub(MainModel mainConpont);


}
