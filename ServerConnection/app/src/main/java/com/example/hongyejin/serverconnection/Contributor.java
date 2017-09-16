package com.example.hongyejin.serverconnection;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class Contributor {

    String name;
    String address;

    int contributions;

    @Override
    public String toString() {
        return name + " (" + address + ")";
    }
}
