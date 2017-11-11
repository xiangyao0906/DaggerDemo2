package com.lettle.xiangyao.daggerdemo2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xiangyao on 2017/11/11.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
