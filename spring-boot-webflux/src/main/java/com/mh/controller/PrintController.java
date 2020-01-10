package com.mh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.controller
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/3 17:16
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RestController
public class PrintController {
    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }
}
