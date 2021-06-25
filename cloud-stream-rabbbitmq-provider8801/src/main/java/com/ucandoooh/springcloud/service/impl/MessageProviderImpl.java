package com.ucandoooh.springcloud.service.impl;

import com.ucandoooh.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author zxn
 * @date 2021/6/25 10:24
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("====>>>>>serial : " + serial);
        return "send serial : " + serial;
    }

    // 每5秒生成消息发送
    /*@InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedRate = "5000"))
    private Message<?> generate() {
        Date date = new Date();
        System.out.println("====>>>>>generate message : " + date.toString());
        return MessageBuilder.withPayload("generate message--" + date.toString()).build();
    }*/
}
