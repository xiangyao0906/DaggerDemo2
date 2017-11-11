package com.lettle.xiangyao.daggerdemo2.contract;

import com.lettle.xiangyao.littledemo.bean.Movie;

/**
 * @author xiangyao
 * @date 2017/11/11
 */

public interface MainContract {

    interface View {

        /**
         * 返回成功的数据
         *
         * @param movie 数据实体
         */
        void showLocationInfo(Movie movie);

        /**
         * 展示错误的信息
         *
         * @param message 错误信息
         */
        void showError(String message);
    }

    interface Presenter {
    }
}
