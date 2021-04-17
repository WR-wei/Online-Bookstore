package com.curry.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author RUIWU
 * @create 2020-11-30 10:11
 */
public class Cart {
//    private Integer totalCount;
//    private Double totalCredit;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    //添加目标课程，成功返回1，失败返回0
    public int addItem(CartItem cartItem) {

        CartItem item = items.get(cartItem.getId());

        if (item == null) {
            items.put(cartItem.getId(), cartItem);
            return 1;
        } else {
            System.out.println("该商品已经添加，请勿重复添加！");
            return 0;
        }
    }

    //删除所选课程
    public void delete(Integer id) {
        items.remove(id);
    }

    //清空选课列表
    public void clear() {
        items.clear();
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (CartItem value : items.values()){
            totalCount++;
        }
        return totalCount;
    }

    public Double getTotalCredit() {
        Double totalCredit = new Double(0);

        for (CartItem value : items.values()){
            totalCredit += value.getCredit();
        }

        return totalCredit;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalCredit=" + getTotalCredit() +
                ", items=" + items +
                '}';
    }
}
