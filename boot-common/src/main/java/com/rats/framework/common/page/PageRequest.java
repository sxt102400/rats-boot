package com.rats.framework.common.page;

import java.io.Serializable;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
public class PageRequest extends Pageable implements Serializable {

    private static final long serialVersionUID = 1232825578694716871L;

    private int pageNo;

    private int pageSize;

    private long totalCount;

    private long totalPage;

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


    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }

    @Override
    public int getPageNo() {
        return pageNo;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public long getTotalPage() {
        return totalPage;
    }

    @Override
    public long getTotalCount() {
        return totalCount;
    }

    public PageRequest previous() {
        return this.getPageNo() == 0 ? this : new PageRequest(this.getPageNo() - 1, this.getPageSize());
    }

    public Pageable first() {
        return new PageRequest(0, this.getPageSize());
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Page request [number: %d, size %d]", this.getPageNo(), this.getPageSize());
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        this.pageSize = this.getPageSize();
        this.totalPage = this.totalCount / this.getPageSize();
        if (this.totalCount % this.getPageSize() != 0) this.totalPage++;
    }
}
