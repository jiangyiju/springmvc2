package com.ebiz.interactive.todo.redis;

import java.io.Serializable;

/**
 * Created by yishang on 2015/10/6.
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = -3766780183428993793L;
    private long id;
    private int sex;

    public Customer(long id, int sex) {
        this.id = id;
        this.sex = sex;
    }

    public Customer(){
    }

    public Customer(int sex) {
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
