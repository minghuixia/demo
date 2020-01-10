package com.mh.properties.controllers;

import cn.hutool.core.lang.Dict;
import com.mh.properties.config.Developer;
import com.mh.properties.config.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.properties.controllers
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2019/12/26 15:56
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RestController
@RequestMapping("print")
public class PrintController {
    private final Server server;
    private final Developer developer;

    @Autowired
    public PrintController(Server server, Developer developer) {
        this.server = server;
        this.developer = developer;
    }

    @GetMapping("server")
    public String server() {
        return server.toString();
    }

    @GetMapping("developer")
    public String developer() {
        return developer.toString();
    }


    @GetMapping
    public Dict print() {
        return Dict.create().set("server", server).set("developer", developer);
    }
}
