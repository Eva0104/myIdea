package com.zhuxiaoxue.entity;

public class Client {

    private Integer id;
    private String baby;
    private String babyMum;
    private Integer money;
    private String card;
    private String types;


    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaby() {
        return baby;
    }

    public void setBaby(String baby) {
        this.baby = baby;
    }

    public String getBabyMum() {
        return babyMum;
    }

    public void setBabyMum(String babyMum) {
        this.babyMum = babyMum;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
