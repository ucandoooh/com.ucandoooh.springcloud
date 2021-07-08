package com.ucandoooh.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxn
 * @date 2021/7/8 14:37
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String url;

    @GetMapping("/consumer/payment/nacos/{name}")
    public String nacos(@PathVariable("name") String name) {
        String rt = restTemplate.getForObject(url + "/payment/nacos/" + name, String.class);
        return String.format("do consumer : %n%s", rt);
    }
}
