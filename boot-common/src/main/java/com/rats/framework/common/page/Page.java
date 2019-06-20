package com.rats.framework.common.page;

import java.util.Iterator;
import java.util.List;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
public interface Page<T> {

    int getPageNo();

    int getPageSize();

    long getTotalPage();

    long getTotalCount();

    boolean hasPrePage();

    boolean hasNextPage();

    boolean isFirstPage();

    boolean isLastPage();

    Iterator<T> iterator();

    Pageable getPageable();

    List<T> getData();

    boolean hasData();

    String toJSONString();
}
