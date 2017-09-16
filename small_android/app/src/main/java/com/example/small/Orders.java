package com.example.small;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class Orders {


    String name;
    Long price;
    Long store_id;
    Long id;

    public Orders(String name, Long price, Long store_id,Long id) {
        this.name = name;
        this.price = price;
        this.store_id = store_id;
        this.id = id;
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
