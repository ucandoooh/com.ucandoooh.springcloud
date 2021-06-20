package com.ucandoooh.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ucandoooh
 * @data 2021/6/20 19:51
 */
@RestController
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String orderConsul() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return "spring cloud consumer : " + result;
    }
}
