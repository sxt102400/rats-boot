package com.rats.framework.common.anno;

import com.rats.framework.base.BaseMapper;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Inherited
public @interface MapperBean {

    Class<? extends BaseMapper> value();
}
