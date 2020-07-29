package com.smile2coder.event.event;


import org.springframework.context.ApplicationEvent;

/**
 * @author ZxT
 * @date 2020-07-29
 * @desc
 */
public class UserRegisterEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
