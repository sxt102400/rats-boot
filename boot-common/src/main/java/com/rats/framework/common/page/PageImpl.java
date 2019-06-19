package com.rats.framework.common.page;

import com.rats.framework.common.utils.JSONUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.domain.PageRequest;

import java.util.*;

public class PageImpl<T> implements Page<T> {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Pageable pageable;

    private List<T> data = new ArrayList();

    public PageImpl(List<T> data, Pageable pageable, long totalCount) {
        this(data, pageable);
        this.pageable.setTotalCount(totalCount);
    }

    public PageImpl(List<T> data, Pageable pageable) {
        this.data.addAll(data);
        this.pageable = pageable;
        if (data != null) {
            this.pageable.setTotalCount(data.size());
        }
    }

    @Override
    public int getPageNo() {
        return pageable.getPageNo();
    }

    @Override
    public int getPageSize() {
        return pageable.getPageSize();
    }


    public int getTotalPage() {
        return this.getPageSize() == 0 ? 1 : (int) Math.ceil((double) this.getTotalCount() / (double) this.getPageSize());
    }

    @Override
    public int getPageCount() {
        return 0;
    }

    @Override
    public long getTotalCount() {
        return pageable.getTotalCount();
    }

    @Override
    public boolean hasPrePage() {
        return false;
    }

    @Override
    public boolean hasNextPage() {
        return false;
    }

    @Override
    public boolean hasData() {
        return data != null;
    }

    @Override
    public boolean isFirstPage() {
        return false;
    }

    @Override
    public boolean isLastPage() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return this.data.iterator();
    }

    @Override
    public Pageable getPageable() {
        return pageable;
    }

    @Override
    public List<T> getData() {
        return this.data;
    }


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toJSONString() {
        Map map = new HashMap();
        map.put("totalCount", this.getTotalCount());
        map.put("totalPage", this.getTotalPage());
        map.put("data", this.getData());
        return JSONUtils.toJSONString(map);
    }
}
