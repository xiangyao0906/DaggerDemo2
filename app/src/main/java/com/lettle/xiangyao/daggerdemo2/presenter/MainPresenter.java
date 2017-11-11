package com.lettle.xiangyao.daggerdemo2.presenter;

import com.lettle.xiangyao.daggerdemo2.api.Api;
import com.lettle.xiangyao.daggerdemo2.contract.MainContract;
import com.lettle.xiangyao.littledemo.bean.Movie;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author xiangyao
 * @date 2017/11/11
 * @Inject 这个注解是用来说明该注解下方的属性或方法需要依赖注入。（如果使用在类构造方法上，则该类也会被注册在DI容器中作为注入对象。很重要，理解这个，就能理解Presenter注入到Activity的步骤！）
 * @Provider 在@Module注解的类中，使用@Provider注解，说明提供依赖注入的具体对象
 * @Component 简单说就是，可以通过Component访问到Module中提供的依赖注入对象。假设，如果有两个Module，AModule、BModule，如果Component只注册了AModule，而没有注册BModule，那么BModule中提供的对象，无法进行依赖注入！
 * @SubComponent 该注解从名字上就能知道，它是子Component，会完全继承父Component的所有依赖注入对象！
 * @Sigleton 被注解的对象，在App中是单例存在的！
 * @Scope 用来标注依赖注入对象的适用范围。
 * @Named(@) 因为Dagger2 的以来注入是使用类型推断的，所以同一类型的对象就无法区分，可以使用@Named注解区分同一类型对象，可以理解为对象的别名！
 */

public class MainPresenter implements MainContract.Presenter {
    private Api api;
    private MainContract.View view;

    @Inject
    public MainPresenter(Api api, MainContract.View view) {
        this.api = api;
        this.view = view;
    }

    public void getMovies(String start, String count) {


        api.getMovie(start, count).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());

                    }

                    @Override
                    public void onNext(Movie movie) {
                        view.showLocationInfo(movie);

                    }
                })
        ;


    }
}
