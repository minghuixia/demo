package com.mh.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.controller
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/3 17:17
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = PrintController.class)
public class PrintControllerTest {
    @Autowired
    WebTestClient client;

    @Test
    public void hello() {
        client.get().uri("/hello").exchange().expectStatus().isOk();
    }
}
