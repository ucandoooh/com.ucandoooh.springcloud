package com.ucandoooh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxn
 * @date 2021/7/8 10:27
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{name}")
    public String nacos(@PathVariable("name") String name) {

        return String.format("nacos say : %s , this is port %s", name, serverPort);
    }
}
