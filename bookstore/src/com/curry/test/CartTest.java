package com.curry.test;

import com.curry.pojo.Cart;
import com.curry.pojo.CartItem;
import org.junit.Test;

/**
 * @author RUIWU
 * @create 2020-11-30 10:53
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"数据结构","王华",new Double(2.5),50));
        cart.addItem(new CartItem(2,"数据","王华",new Double(3.0),50));
        cart.addItem(new CartItem(3,"数","王华",new Double(4.5),50));
        System.out.println(cart);
    }

    @Test
    public void delete() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"数据结构","王华",new Double(2.5),50));
        cart.addItem(new CartItem(2,"数据","王华",new Double(3.0),50));
        cart.addItem(new CartItem(3,"数","王华",new Double(4.5),50));
        cart.delete(3);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"数据结构","王华",new Double(2.5),50));
        cart.addItem(new CartItem(2,"数据","王华",new Double(3.0),50));
        cart.addItem(new CartItem(3,"数","王华",new Double(4.5),50));
        cart.clear();
        System.out.println(cart);
    }
}