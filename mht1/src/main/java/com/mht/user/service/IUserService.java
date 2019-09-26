package com.mht.user.service;

import com.mht.user.bean.User;
import com.mht.util.beanUtils.ResultInfo;

public interface IUserService {

    //微信小程序，用户第一次登陆保存用户信息
    public ResultInfo appSave(String userName, String code);

    //注册
    public ResultInfo pcRegist(User user);

    //登陆
    public ResultInfo login(User user);

    //修改密码
    public ResultInfo updatePassword(String userName, String oldPassword, String newPassword);


}
