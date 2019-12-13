package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hezhensheng
 * @version 1.0
 * @description HelloWorldController
 * @date 2019/9/5 18:47
 */

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        String str1 = "新增的分支上添加一个字符串";
        return "Hello World";
    }
}
