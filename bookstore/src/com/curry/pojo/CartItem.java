package com.curry.pojo;

/**
 * 购物车的商品项
 *
 * @author RUIWU
 * @create 2020-11-30 10:06
 */
public class CartItem {
    private Integer id;
    private String name;
    private String teacher;
    private Double Credit;
    private Integer totalNum;

    public CartItem() {
    }

    public CartItem(Integer id, String name, String teacher, Double credit, Integer totalNum) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        Credit = credit;
        this.totalNum = totalNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Double getCredit() {
        return Credit;
    }

    public void setCredit(Double credit) {
        Credit = credit;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", Credit=" + Credit +
                ", totalNum=" + totalNum +
                '}';
    }
}
