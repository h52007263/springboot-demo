package com.example.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Hero;
import com.luxsuen.jsonutil.util.JsonUtil;
import net.minidev.json.JSONUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description ListTest
 * @date 2019/12/7 22:42
 */

public class ListTest {
    @Test
    public void test1() {
        List<Hero> heros = getHeros(10);
        heros
                .stream()
//                .filter(h -> (h.getDamage() > 5 && h.getDamage() < 9))
//                .distinct()
//                .sorted((h1, h2) -> (h1.getPrice() < h2.getPrice() ? 1 : -1))
//                .limit(3)
//                .skip(3)
//                .mapToDouble(Hero::getPrice)
                .map((h) -> h.getDamage() + "-" + h.getName())
                .forEach(h -> System.out.println(JSON.toJSONString(h)));

        /**
         * 管道源： List
         * 中间操作： 分为两类，筛选元素和转换为其他流，中间操作会返回一个stream，继续进行中间操作
         * 结束操作：流被用光，不返回stream，会返回int，float，String，Collection，foreach
         * 将Collection切换成管道源很简单，list.stream()
         * 数组用Array.Stream(hs)
         */

    }

    private List<Hero> getHeros(int total) {
        List<Hero> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero();
            hero.setName("hero" + i);
            hero.setPrice(new Float(i));
            hero.setDamage(i);
            list.add(hero);
        }
        for (int i = 0; i < 2; i++) {
            Hero hero = new Hero();
            hero.setName("hero" + i);
            hero.setPrice(new Float(i));
            hero.setDamage(i);
            list.add(hero);
        }
        return list;
    }

}
