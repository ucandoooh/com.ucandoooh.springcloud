package com.ucandoooh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxn
 * @date 2021/6/24 15:46
 */
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;
    
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/config")
    public String config() {
        return serverPort + " ===>>> " + configInfo;
    }

}
