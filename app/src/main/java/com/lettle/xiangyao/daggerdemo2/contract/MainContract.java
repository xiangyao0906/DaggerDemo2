package com.lettle.xiangyao.daggerdemo2.contract;

import com.lettle.xiangyao.littledemo.bean.Movie;

/**
 * Created by xiangyao on 2017/11/11.
 */

public interface MainContract {


    interface View {


        void showLocationInfo(Movie movie);

        void showError(String message);
    }

    interface Presenter {
    }
}
