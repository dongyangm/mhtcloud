package com.mht.user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mht.user.bean.User;
import com.mht.user.dao.UserRepo;
import com.mht.util.beanUtils.ResultInfo;
import com.mht.util.jwtutil.JwtUtil;
import com.mht.util.restTemplateUtils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Value("${appid}")
    String appid;

    @Value("${secret}")
    String secret;

    @Autowired
    private UserRepo userRepo;

    @Transactional
    public ResultInfo appSave (String userName, String code){
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        User user = new User();
        user.setUserName(userName);
        user.setUserAuth(2);
        user.setOrderPermission(0);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        int value = forEntity.getStatusCodeValue();

        if (value == 200){
            //初始化信息获取成功
            JSONObject parseInfo = (JSONObject) JSON.parse(forEntity.getBody());
            Object openid = parseInfo.get("openid");
            HashMap<String, Object> result = new HashMap<>();
            result.put("token", JwtUtil.createJWT(openid.toString()));
            if (openid != null){
                //查询是否存在该账号数据
                User byAccount = userRepo.findByAccount(openid.toString());
                if (byAccount != null){
                    //存在用户数据，不再做保存
                    result.put("user",byAccount);
                    return new ResultInfo(true,result,2);
                }
                //保存用户信息到数据库
                user.setId(UUID.randomUUID().toString().replace("-",""));
                user.setAccount(openid.toString());
                User save = userRepo.save(user);
                result.put("user",save);
                return new ResultInfo(true,result,1);
            }else{
                //获取信息失败
                return new ResultInfo(true,parseInfo,0);
            }
        }
        //获取微信用户信息网络异常
        return new ResultInfo(true,null,-1);
    }

    @Override
    public ResultInfo pcRegist(User user) {

        String replace = UUID.randomUUID().toString().replace("-", "");
        User byAccount = userRepo.findByAccount(user.getAccount());
        if (byAccount == null){
            user.setId(replace);
            user.setCreateTime(new Date());
            user.setUserAuth(2);
            User save = userRepo.save(user);
            save.setPassword("");
            HashMap<String, Object> result = new HashMap<>();
            result.put("user",save);
            result.put("token", JwtUtil.createJWT(user.getAccount()));
            return new ResultInfo(true,result,1);
        }
        //已存在该用户名
        byAccount.setPassword("");
        return new ResultInfo(true,null,-1);
    }

    @Override
    public ResultInfo login(User user) {
        User authUser = userRepo.findByAccountAndPassword(user.getAccount(), user.getPassword());
        if (authUser == null){
            //登录失败
            return new ResultInfo(true,null,-1);
        }
        authUser.setPassword("");
        HashMap<String, Object> result = new HashMap<>();
        result.put("user",authUser);
        result.put("token", JwtUtil.createJWT(user.getAccount()));
        return new ResultInfo(true,result,1);
    }

    @Override
    public ResultInfo updatePassword(String userName, String oldPassword, String newPassword) {
        User user = userRepo.findByAccountAndPassword(userName, newPassword);
        if (user!=null){
            user.setPassword(newPassword);
            User save = userRepo.save(user);
            save.setPassword("");
            return new ResultInfo(true,save,1);
        }
        return new ResultInfo(true,null,-1);
    }
}
