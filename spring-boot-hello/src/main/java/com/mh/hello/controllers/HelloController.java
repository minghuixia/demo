package com.mh.hello.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.hello.controllers
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2019/12/26 15:17
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping("say")
    public String say() {
        return "hello world";
    }

    @GetMapping("say/{name}")
    public String say(@PathVariable("name") String name) {
        return "hello " + name;
    }
}
