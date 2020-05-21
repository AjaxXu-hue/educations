package org.order.config.rabbitmq;

import pojo.user.User;

public class MiaoshaMessage {

    private User user;
    private Long miaoshaId;

    @Override
    public String toString() {
        return "MiaoshaMessage{" +
                "user=" + user +
                ", miaoshaId=" + miaoshaId +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getMiaoshaId() {
        return miaoshaId;
    }

    public void setMiaoshaId(Long miaoshaId) {
        this.miaoshaId = miaoshaId;
    }
}
