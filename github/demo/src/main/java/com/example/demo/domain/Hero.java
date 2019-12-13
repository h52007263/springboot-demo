package com.example.demo.domain;

import java.util.Objects;

/**
 * @author hezhensheng
 * @version 1.0
 * @description Hero
 * @date 2019/12/7 22:52
 */

public class Hero {
    private String name;
    private Float price;
    private Integer damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name) &&
                Objects.equals(price, hero.price) &&
                Objects.equals(damage, hero.damage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, damage);
    }
}
