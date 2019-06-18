package com.rats.framework.common.page;

import com.rats.framework.common.utils.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.session.RowBounds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.*;

/**
 * Copyright (C) aisainfo
 *
 * Title: 分页组件
 * Description: 分页组件:Pageable.java
 *
 * @author hanbing
 * @version V1.0
 * @since 2015/5/27
 */
public abstract class Pageable extends RowBounds   {

    public static final int DEFAULT_PAGE_SIZE = 10;

    public abstract int getPageNo();

    public abstract int getPageSize();

    public abstract long getTotalCount();

    public abstract void setTotalCount(long totalCount);

    public static PageRequest of(int page) {
        return new  PageRequest(page, DEFAULT_PAGE_SIZE);
    }

    public static PageRequest of(int page, int size) {
        return new  PageRequest(page, size);
    }

}
