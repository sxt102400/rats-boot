package com.rats.framework.common.page.prop;

import com.rats.framework.utils.SpringContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
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
