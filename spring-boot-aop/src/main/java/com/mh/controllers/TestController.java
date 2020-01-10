package com.mh.controllers;

import cn.hutool.core.lang.Dict;
import com.mh.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.controllers
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/7 15:26
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("say/{param}")
    public Dict say(@PathVariable("param") String param) {
        Dict dict = testService.select(param);
        if (Objects.isNull(dict)) {
            return Dict.create().set("message", "系统异常");
        }
        return dict;
    }
}
