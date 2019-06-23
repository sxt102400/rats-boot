package com.rats.framework.common.page;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
public class PageImpl<T> implements Page<T> {

    private static final long serialVersionUID = 1L;

    private int pageNo;

    private int pageSize;

    private long totalPage;

    private long totalCount;

    private List<T> data = new ArrayList();

    public PageImpl(List<T> data, Pageable pageable, long totalCount) {
        this.data.addAll(data);
        pageable.setTotalCount(totalCount);
        this.pageSize = pageable.getPageSize();
        this.pageNo = pageable.getPageNo();
        this.totalPage = pageable.getTotalPage();
        this.totalCount = pageable.getTotalCount();
    }

    public PageImpl(List<T> data, Pageable pageable) {
        if (data != null) {
            this.data.addAll(data);
            pageable.setTotalCount(data.size());
        }
        this.pageSize = pageable.getPageSize();
        this.pageNo = pageable.getPageNo();
        this.totalPage = pageable.getTotalPage();
        this.totalCount = pageable.getTotalCount();

    }


    @Override
    public int getPageNo() {
        return pageNo;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    @Override
    public long getTotalCount() {
        return totalCount;
    }

    @Override
    public boolean hasPrePage() {
        return pageNo > 1;
    }

    @Override
    public boolean hasNextPage() {
        return pageNo < totalPage;
    }

    @Override
    public boolean hasData() {
        return data != null && data.size() > 0;
    }

    @Override
    public boolean isFirstPage() {
        return pageNo == 1;
    }

    @Override
    public boolean isLastPage() {
        return pageNo == totalPage;
    }

    @Override
    public List<T> getData() {
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
