package com.rats.framework.common.anno;

import com.rats.framework.common.base.BaseMapper;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Inherited
public @interface ImportMapper {

    Class<? extends BaseMapper> value();
}
