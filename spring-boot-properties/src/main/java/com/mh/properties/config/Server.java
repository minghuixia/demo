package com.mh.properties.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.properties.config
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2019/12/26 15:47
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Data
@Component
@PropertySource("classpath:server.properties")
public class Server {
    @Value("${demo.server.name}")
    private String name;
    @Value("${demo.server.declare}")
    private String declare;
}
