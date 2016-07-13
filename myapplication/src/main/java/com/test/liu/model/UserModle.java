package com.test.liu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/24.
 * 用户对象实体类
 */
public class UserModle implements Serializable {
    private int id;
    private String name;
    private String password;
    private String sex;
    private int age;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserModle(String name, String password, String sex, int age, String address) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }
}
