package com.ucandoooh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ucandoooh
 * @data 2021/6/20 19:31
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "spring cloud with zookeeper : " + serverPort + " : " + UUID.randomUUID().toString();
    }
}
