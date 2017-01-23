package com.easytrade.easytradelib;
/**
 * Created by muzcategui1106 on 1/23/2017.
 */
public class Greeting {
    private long id;
    private String content;

    public Greeting(){

    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}