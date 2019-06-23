package com.rats.framework.common.page.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "paging")
public class PagingProperties {

    public static final String PAGE_PREFIX = "paging";

    private final ParamName paramName = new ParamName();

    private final DefaultValue defaultValue = new DefaultValue();

    public ParamName getParamName() {
        return paramName;
    }

    public DefaultValue getDefaultValue() {
        return defaultValue;
    }

    public static class ParamName {

        private String pageNo = "pageNo";
        private String pageSize = "pageSize";

        public String getPageNo() {
            return pageNo;
        }

        public void setPageNo(String pageNo) {
            this.pageNo = pageNo;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class DefaultValue {
        private int pageNo = 1;
        private int pageSize = 20;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }
}
