package com.ucandoooh.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ucandoooh
 * @data 2021/6/20 14:03
 */
@RestController
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String orderZk() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return "spring cloud consumer : " + result;
    }
}
