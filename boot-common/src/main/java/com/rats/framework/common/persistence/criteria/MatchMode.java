package com.rats.framework.common.persistence.criteria;

/**
 * @author hanbing
 * @ClassName: Criterion
 * @Description: like的exact描述，参考实现org.hibernate.criterion.MatchMode
 */
public enum MatchMode {

    EXACT {
        public String toMatchString(String pattern) {
            return pattern;
        }
    },
    START {
        public String toMatchString(String pattern) {
            return pattern + '%';
        }
    },
    END {
        public String toMatchString(String pattern) {
            return '%' + pattern;
        }
    },
    ANYWHERE {
        public String toMatchString(String pattern) {
            return '%' + pattern + '%';
        }
    };

    private MatchMode() {
    }

    public abstract String toMatchString(String var1);


}
