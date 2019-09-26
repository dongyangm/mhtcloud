package com.mht.user;

import com.mht.user.bean.User;
import com.mht.user.service.IUserService;
import com.mht.util.beanUtils.ResultInfo;
import com.mht.util.jwtutil.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     *app添加用户信息
     * @return
     */
    @GetMapping("/appSave")
    public ResultInfo appSave(String userName,String code){

        return  userService.appSave(userName,code);
    }

    /**
     * PC端用户注册
     * @param user
     * @return
     */
    @PostMapping("/pcRegister")
    public  ResultInfo pcRegister(@RequestBody User user){
        return  userService.pcRegist(user);
    }

    /**
     * pc登陆
     * @param user
     * @return
     */
    @PostMapping("/pcLogin")
    public ResultInfo pcLogin(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 未登录
     * @param
     * @return
     */
    @GetMapping("/noLogin")
    public ResultInfo noLogin(){
        return new ResultInfo(true,null,-1);
    }
    /**
     * 超时，生成新的token
     * @param
     * @return
     */
    @PostMapping("/createToken")
    public ResultInfo createToken(HttpServletRequest request){
        return new ResultInfo(true, JwtUtil.createJWT(request.getHeader("account")),1);
    }

    /**
     * 超时，生成新的token
     * @param
     * @return
     */
    @PostMapping("/testRequest")
    public String testRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "forward:/mht/user/createToken";
    }




}
