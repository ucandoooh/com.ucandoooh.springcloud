package com.ucandoooh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zxn
 * @date 2021/6/21 11:18
 */
@Component
public class MyLoadBalanceImpl implements MyLoadBalance{

    AtomicInteger invokeTimeAtomicInteger = new AtomicInteger(0);

    private final int getAndIncrease() {
        int expect = 0;
        int update = 0;
        do {
            expect = invokeTimeAtomicInteger.get();
            update = update == Integer.MAX_VALUE ? 0 : expect + 1;
        } while (!invokeTimeAtomicInteger.compareAndSet(expect, update));
        return update;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList) {
        if (serviceInstanceList == null || serviceInstanceList.isEmpty()) {
            return null;
        }
        int index = getAndIncrease() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
