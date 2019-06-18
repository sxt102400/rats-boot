package com.rats.framework.common.page;

import java.io.Serializable;

public class PageRequest extends Pageable implements Serializable {


    private static final long serialVersionUID = 1232825578694716871L;

    public static final int DEFAULT_PAGE_SIZE = 10;
    /**
     * 分页每页页面记录数，设置为“-1”表示不进行分页（分页无效）
     */
    private final int pageNo;

    private final int pageSize;

    private long totalCount;

    private long totalPage;

    private int offset;

    private int limit;

    public static PageRequest of(int page) {
        return new  PageRequest(page, DEFAULT_PAGE_SIZE);
    }

    public static PageRequest of(int page, int size) {
        return new  PageRequest(page, size);
    }

    private PageRequest(int page, int size) {
        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        } else if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        } else {
            this.pageNo = page;
            this.pageSize = size;
        }
    }

    public PageRequest previous() {
        return this.getPageNo() == 0 ? this : new PageRequest(this.getPageNo() - 1, this.getPageSize());
    }

    public Pageable first() {
        return new PageRequest(0, this.getPageSize());
    }

    @Override
    public int getPageNo() {
         return pageNo;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    public int hashCode() {
        return 31 * super.hashCode();
    }

    public String toString() {
        return String.format("Page request [number: %d, size %d]", this.getPageNo(), this.getPageSize());
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        this.limit = this.getPageSize();
        this.totalPage = this.totalCount / this.getPageSize();
        if (this.totalCount % this.getPageSize() != 0) this.totalPage++;
    }
}
