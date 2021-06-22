package com.ucandoooh.springcloud.serivce;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zxn
 * @date 2021/6/22 10:29
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "Thread pool" + Thread.currentThread().getName() + "===>>>paymentInfo_OK, id:" + id + "===>>>O(∩_∩)O哈哈0";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int i = 10/0;
        int timeout = 2;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread pool" + Thread.currentThread().getName() + "===>>>paymentInfo_TimeOut, id:"
                + id + "===>>>/(ㄒoㄒ)/呜呜" + "timeout(s):" + timeout;
    }

    public String paymentInfo_TimeOut_fallback(Integer id) {
        return "Thread pool" + Thread.currentThread().getName() + "===>>>paymentInfo_TimeOut_fallback, id:" + id;
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("===>>> id 不能为负数 <<<===");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " 调用成功，流水号：" + serialNum;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return Thread.currentThread().getName() + " id 不能为负数，请稍后重试, id=" + id;
    }

}
