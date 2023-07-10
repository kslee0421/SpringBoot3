package com.hschool.demo.entity;

public class Member {  //레파지토리 Class와 연결된 데이터베이스
    private Integer id;
    private  String name;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
