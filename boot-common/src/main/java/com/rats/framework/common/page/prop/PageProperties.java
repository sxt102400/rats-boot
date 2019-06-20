package com.rats.framework.common.page.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hanbing
 * @date 2019-0620
 * @since 1.0.0
 */
@Component
@ConfigurationProperties("page")
public class PageProperties {

    private PageNo pageNo;

    private PageSize pageSize;

    public static class PageNo {
        private String paramName;
        private int defaultValue;

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public int getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(int defaultValue) {
            this.defaultValue = defaultValue;
        }
    }

    public static class PageSize {
        private String paramName;
        private int defaultValue;

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public int getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(int defaultValue) {
            this.defaultValue = defaultValue;
        }
    }

    public PageNo getPageNo() {
        return pageNo;
    }

    public void setPageNo(PageNo pageNo) {
        this.pageNo = pageNo;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }


}
