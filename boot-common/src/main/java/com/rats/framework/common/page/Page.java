package com.rats.framework.common.page;




import java.util.Iterator;
import java.util.List;

public interface Page<T>{

    int getPageNo();            //当前第几页   返回当前页的数目。总是非负的

    int getPageSize();              //返回当前页面的大小。

    int getTotalPage();         //返回分页总数。

    int getPageCount();    //返回当前页上的元素数。

    long getTotalCount();   //返回元素总数。

    boolean hasPrePage();  //返回如果有上一页。

    boolean hasNextPage();      //返回如果有下一页。

    boolean isFirstPage();      //返回当前页是否为第一页。

    boolean isLastPage();       //返回当前页是否为最后一页。

    Iterator<T> iterator();

    Pageable getPageable();

    List<T> getData();     //将所有数据返回为List

    boolean hasData();     //返回数据是否有内容。

    String toJSONString();
}
