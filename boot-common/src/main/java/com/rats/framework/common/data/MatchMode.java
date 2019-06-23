package com.rats.framework.common.data;

/**
 * @author hanbing
 * @ClassName: Criterion
 * @Description: like的exact描述，参考实现org.hibernate.criterion.MatchMode
 */
public enum MatchMode {

    EXACT {
        public String contact(String pattern) {
            return pattern;
        }
    },
    START {
        public String contact(String pattern) {
            return pattern + "%";
        }
    },
    END {
        public String contact(String pattern) {
            return "%" + pattern;
        }
    },
    ANY {
        public String contact(String pattern) {
            return "%" + pattern + "%";
        }
    };

    MatchMode() {
    }

    public abstract String contact(String var1);
}
