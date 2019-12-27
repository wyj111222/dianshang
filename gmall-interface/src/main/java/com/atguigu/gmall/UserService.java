package com.atguigu.gmall;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户数据
     * @return
     */
    List<UserInfo> findAll();
    /**
     * 根据用户Id 查询收货地址列表！
     */
    List<UserAddress> findUserAddressByUserId(String userId);
}
