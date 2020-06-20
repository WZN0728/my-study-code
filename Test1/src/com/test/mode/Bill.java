package com.test.mode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class Bill {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public void remove(Item item){
        items.remove(item);
    }

    public int getSums(){
        return items.stream().mapToInt(item -> item.getCents()).sum();
    }

    public void pay(PaymentMethod paymentMethod){
        paymentMethod.pay(getSums());
    }

}
