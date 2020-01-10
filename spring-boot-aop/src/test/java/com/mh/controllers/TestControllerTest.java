package com.mh.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.controllers
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/7 15:56
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = TestController.class)
public class TestControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void say() {
        webTestClient.get().uri("/say").exchange().expectStatus().isOk();
    }
}
