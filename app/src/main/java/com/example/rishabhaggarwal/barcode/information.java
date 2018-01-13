package com.example.rishabhaggarwal.barcode;


/**
 * Created by Rishabh Aggarwal on 14-04-2017.
 */

public class information {
    public static String format;
    public static String content;
    public static String price;
    public static String ptype;
    public static String aid;
    public static String password;

    public information() {

    }

    public information(String format, String content, String price, String ptype) {
        this.format = ptype;
        this.content = content;
        this.price = price;
        this.ptype=ptype;


    }
    public information(String aid, String password){
        this.aid=aid;
        this.password=password;
    }


    public static void setFormat(String ptype) {
        information.format = format;
    }

    public static void setContent(String content) {
        information.content = content;
    }

    public static void setPrice(String price) {
        information.price = price;
    }

    public static void setAid(String aid) {
        information.aid = aid;
    }

    public static void setPassword(String password) {
        information.password = password;
    }

    public static void setPtype(String ptype) {
        information.ptype = ptype;
    }

    public static String getFormat() {
        return ptype;
    }

    public static String getContent() {
        return content;
    }

    public static String getPrice() {
        return price;
    }

    public static String getAid() {
        return aid;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPtype() {
        return ptype;
    }
}
