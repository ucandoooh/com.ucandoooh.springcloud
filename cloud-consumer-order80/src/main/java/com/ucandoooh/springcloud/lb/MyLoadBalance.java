package com.ucandoooh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zxn
 * @date 2021/6/21 11:17
 */
public interface MyLoadBalance {

    ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList);
}
