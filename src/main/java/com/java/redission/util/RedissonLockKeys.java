package com.java.redission.util;

public class RedissonLockKeys {
    public static  String getTicketOrderkey (String orderNo){
        return "lock:ticket:order"+orderNo;
    }
    public static  String getTttInventoryKey (Integer id){
        return "lock:ticket:ttt:inventory"+id;
    }
    public static  String getMerchantInventoryKey (Integer id){
        return "lock:ticket:merchant:inventory"+id;
    }
    public static  String getPresaleInventoryKey (Integer id){
        return "lock:ticket:presale:inventory"+id;
    }
}
