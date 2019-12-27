package com.atguigu.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.UserService;
import com.atguigu.gmall.bean.UserAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Reference
    private UserService userService;

    @RequestMapping("trade")
    public List<UserAddress> findUserAddressByUserId(String userId){
        return userService.findUserAddressByUserId(userId);
    }
}
