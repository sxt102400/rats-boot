package com.rats.framework.common.page.prop;

import com.rats.framework.utils.SpringContextHolder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
@Component
@EnableConfigurationProperties(PagingProperties.class)
public class Paging {

    private static PagingProperties.ParamName paramName;
    private static PagingProperties.DefaultValue defaultValue;

    @Resource
    private PagingProperties prop;

    @PostConstruct
    private void initConfig() {
        paramName = prop.getParamName();
        defaultValue = prop.getDefaultValue();
    }

    protected static PagingProperties.ParamName paramName() {
        return paramName;
    }

    protected static PagingProperties.DefaultValue defaultValue() {
       return defaultValue;
    }
}