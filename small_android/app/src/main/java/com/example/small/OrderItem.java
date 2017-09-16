package com.example.small;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class OrderItem {


    Long quantity;
    Long unitPrice;
    Long sales_order_id;
    Long items_id;



    public OrderItem(Long quantity, Long unitPrice, Long sales_order_id, Long items_id) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.sales_order_id = sales_order_id;
        this.items_id = items_id;
    }








}
