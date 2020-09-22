package com.kyrie.feature.annotation;

import java.lang.annotation.*;

/**
 * Created by tend on 2020/9/22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Inheritable {
}

