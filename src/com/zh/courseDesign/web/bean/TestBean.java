package com.zh.courseDesign.web.bean;

/**
 * @author MaCode
 * @date 2020-11-29
 * @github HappyOnion801
 */
public class TestBean {
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public TestBean(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public TestBean() {
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
