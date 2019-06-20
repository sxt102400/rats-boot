package com.rats.framework.data;

/**
 * @author hanbing
 * @ClassName: Criterion
 * @Description: like的exact描述，参考实现org.hibernate.criterion.MatchMode
 */
public enum MatchMode {

    EXACT {
        public String of(String pattern) {
            return pattern;
        }
    },
    START {
        public String of(String pattern) {
            return pattern + "%";
        }
    },
    END {
        public String of(String pattern) {
            return "%" + pattern;
        }
    },
    ANY {
        public String of(String pattern) {
            return "%" + pattern + "%";
        }
    };

    MatchMode() {
    }

    public abstract String of(String var1);
}
