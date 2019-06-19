package com.rats.framework.common.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
@Documented
@Inherited  //可以继承
public @interface WithMapper {

    Class<?> value();
}
