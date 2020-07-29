package com.smile2coder.event.normal;

import com.smile2coder.event.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * @author ZxT
 * @date 2020-07-29
 * @desc
 */
//@Component
public class CouponListener implements ApplicationListener<UserRegisterEvent>, Ordered {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        Object source = event.getSource();
        System.out.println(String.format("给%s发送优惠券", source.toString()));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
