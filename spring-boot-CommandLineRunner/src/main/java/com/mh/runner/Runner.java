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
 * @date: Created in 2020/1/3 16:58
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Component
@Slf4j
@Order(0)
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("The Runner start to initialize ...");
    }
}
