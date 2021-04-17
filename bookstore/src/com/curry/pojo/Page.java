package com.curry.pojo;

import java.util.List;

/**
 * PAGE模型
 *
 * @author RUIWU
 * @create 2020-11-26 16:07
 */
public class Page<T> {
    //每页显示的记录数
    public static final Integer PAGE_SIZE = 4;
    //总页码
    private Integer pageTotal;
    //当前页码数
    private Integer pageNo;
    //总记录数
    private Integer PageTotalCount;
    //当前页码显示的数据
    private List<T> items;
    //分页条的请求地址
    private String url;
    //当前页总记录数
    private Integer size;

    @Override
    public String toString() {
        return "Page{" +
                "pageTotal=" + pageTotal +
                ", pageNo=" + pageNo +
                ", PageTotalCount=" + PageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {

        //数据边界的有效检查
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }

        this.pageNo = pageNo;
    }

    public Integer getPageTotalCount() {
        return PageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        PageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }


    public Integer getSize() {
        return items.size();
    }

}
