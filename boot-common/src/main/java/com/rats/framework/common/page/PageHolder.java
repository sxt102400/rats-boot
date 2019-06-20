package com.rats.framework.common.page;


/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
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
