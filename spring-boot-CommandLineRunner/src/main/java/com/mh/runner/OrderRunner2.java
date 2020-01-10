package com.mh.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.runner
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/3 16:59
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Component
@Order(2)
@Slf4j
public class OrderRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("The OrderRunner2 start to initialize ...");
    }
}
