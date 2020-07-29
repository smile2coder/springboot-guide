package com.smile2coder.event.annotation;

import com.smile2coder.event.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ZxT
 * @date 2020-07-29
 * @desc
 */
@Component
public class CouponListener {

    @Order(value = 1)
    @EventListener(classes = UserRegisterEvent.class)
    @Async
    public void onApplicationEvent(UserRegisterEvent event) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object source = event.getSource();
        System.out.println(String.format("给%s发送优惠券", source.toString()));
    }
}
