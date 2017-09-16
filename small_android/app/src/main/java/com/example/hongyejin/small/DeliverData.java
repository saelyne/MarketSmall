package com.example.hongyejin.small;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class DeliverData {

    private String userName, userAddress, userNumber;
    private int cid;
    private boolean isDelivered = false;


    public DeliverData(int cid, String name, String address, String number) {
        this.cid=cid;
        this.userName=name;
        this.userAddress=address;
        this.userNumber=number;

    }

    public int getCid(){
        return cid;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNum() {
        return userNumber;
    }


    public String getUserAddress() {
        return userAddress;
    }

}
