package com.rats.framework.common.page;

import org.apache.ibatis.session.RowBounds;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
public abstract class Pageable extends RowBounds   {

    public abstract int getPageNo();

    public abstract int getPageSize();

    public abstract long getTotalPage();

    public abstract long getTotalCount();

    public abstract void setTotalCount(long totalCount);

}
