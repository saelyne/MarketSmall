package com.example.small;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class Orders {


    String name;
    Long price;
    Long store_id;
    Long id;
    Long quantity;
    Long sales_order_id;
    Object item;

    public Orders(String name, Long price, Long store_id,Long id) {
        this.name = name;
        this.price = price;
        this.store_id = store_id;
        this.id = id;
    }

    public Orders(String name, Long price, Long store_id,Long id, Long quantity, Long sales_order_id) {
        this.name = name;
        this.price = price;
        this.store_id = store_id;
        this.id = id;
        this.quantity= quantity;
        this.sales_order_id = sales_order_id;
    }
    public void setSales(Long sales_order_id){
        this.sales_order_id=sales_order_id;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "{" +
                "\"name\"=" + name +
                ", \"price\"='" + price + '\'' +
                ", \"store_id\"='" + store_id + '\'' +
                ", \"id\"='" + id + '\'' +
                '}';
    }
}
