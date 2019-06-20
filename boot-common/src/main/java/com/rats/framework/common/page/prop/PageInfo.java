package com.rats.framework.common.page.prop;

import com.rats.framework.utils.SpringContextHolder;
import org.springframework.stereotype.Component;

@Component
public class PageInfo {

    protected static PageProperties.PageNo pageNo(){
        PageProperties bean = SpringContextHolder.getBean(PageProperties.class);
        return bean.getPageNo();
    }

    protected static PageProperties.PageSize pageSize(){
        PageProperties bean = SpringContextHolder.getBean(PageProperties.class);
        return bean.getPageSize();
    }
}
