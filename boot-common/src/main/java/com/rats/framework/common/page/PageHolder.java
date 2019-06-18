package com.rats.framework.common.page;

/**
 * DataSourceHolder上下文
 */
public class PageHolder {

    private static final ThreadLocal<Pageable> pageHolder = new ThreadLocal<Pageable>();

    public static void setPage(Pageable pageable) {
        if (!pageable.equals(pageHolder.get())) {
            pageHolder.set(pageable);
        }
    }

    public static Pageable getPage() {
        return pageHolder.get();
    }

    public static void clearContext() {
        pageHolder.remove();
    }
}
