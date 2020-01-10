package com.mh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/3 16:56
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@SpringBootApplication
@Slf4j
public class CommandLineRunnerApplication {
    public static void main(String[] args) {
        log.info("The service to start.");
        SpringApplication.run(CommandLineRunnerApplication.class, args);
        log.info("The service has started.");
    }
}
