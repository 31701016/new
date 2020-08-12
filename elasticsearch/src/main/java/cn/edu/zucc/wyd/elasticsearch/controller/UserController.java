package cn.edu.zucc.wyd.elasticsearch.controller;

import cn.edu.zucc.wyd.elasticsearch.form.MyResult;
import cn.edu.zucc.wyd.elasticsearch.entity.UserEntity;
import cn.edu.zucc.wyd.elasticsearch.form.User;
import cn.edu.zucc.wyd.elasticsearch.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin
public class UserController {

    private final UserRepository repository;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public MyResult<UserEntity> login(@RequestBody  User user){
        //登录
        MyResult<UserEntity> myResult = new MyResult<UserEntity>();
        if(user.getLoginname().equals("")||user.getPassword().equals("")){
            myResult.setCode(1);
            myResult.setMsg("用户名或密码不能为空");
            return myResult;
        }
        UserEntity entity = repository.findByLoginname(user.getLoginname());
        if(entity == null){
            myResult.setCode(1);
            myResult.setMsg("用户名不存在");
            return myResult;
        }
        if(!entity.getPassword().equals(user.getPassword())){
            myResult.setCode(1);
            myResult.setMsg("密码错误");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("登录成功");
        myResult.setObj(entity);
        myResult.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        return myResult;

    }

    @PostMapping("/register")
    public MyResult<UserEntity> register(@RequestBody  User user){
//        用户注册
        MyResult<UserEntity> myResult = new MyResult<UserEntity>();
        if(user.getLoginname().equals("")||user.getPassword().equals("")){
            myResult.setCode(1);
            myResult.setMsg("用户名或密码不能为空");
            return myResult;
        }

        UserEntity entity = repository.findByLoginname(user.getLoginname());
        if(entity != null){
            myResult.setCode(1);
            myResult.setMsg("用户名已存在");
            return myResult;
        }
        else {
            UserEntity entity1 = new UserEntity();
            entity1.setLoginname(user.getLoginname());
            entity1.setPassword(user.getPassword());
            entity1.setUserType("user");
            entity1.setEmail("未设定");
            entity1.setCellphone("未设定");
            repository.save(entity1);
            myResult.setCode(0);
            myResult.setMsg("注册成功");
            return myResult;
        }
    }

    @PostMapping("/changeinfo")
    public MyResult<UserEntity> changeinfo(@RequestBody  User user){
        //修改用户信息
        MyResult<UserEntity> myResult = new MyResult<UserEntity>();
        UserEntity entity = new UserEntity();
        entity = repository.findByLoginname(user.getLoginname());
        if(!"".equals(user.getEmail())){
            if (!user.getEmail().matches("\\w{6,15}(\\.\\w+)*@[A-z0-9]{2,5}+(\\.[A-z]{2,4}){1,4}$")) {
                myResult.setCode(1);
                myResult.setMsg("输入的邮箱格式不合法！");
                return myResult;
            }
            entity.setEmail(user.getEmail());
        }
        if(!"".equals(user.getCellphone())){
            if(!user.getCellphone().matches("^(13|15|18)\\d{9}$")){
                myResult.setCode(1);
                myResult.setMsg("输入的手机号不合法！");
                return myResult;
            }
            entity.setCellphone(user.getCellphone());
        }
        repository.save(entity);
        myResult.setCode(0);
        myResult.setMsg("修改成功！");
        myResult.setObj(entity);
        return myResult;
    }

    @PostMapping("/changepassword")
    public MyResult<UserEntity> changepassword(@RequestBody  User user){
//        修改用户密码
        MyResult<UserEntity> myResult = new MyResult<UserEntity>();
        if(user.getPassword().equals("")){
            myResult.setCode(1);
            myResult.setMsg("原密码不能为空！");
            return myResult;
        }
        if(user.getNewpassword().equals("")){
            myResult.setCode(1);
            myResult.setMsg("新密码不能为空！");
            return myResult;
        }
        if(!user.getNewpassword().equals(user.getNewpassword1())){
            myResult.setCode(1);
            myResult.setMsg("两次密码不一致！");
            return myResult;
        }

        UserEntity entity = new UserEntity();
        entity = repository.findByLoginname(user.getLoginname());
        if(!entity.getPassword().equals(user.getPassword())){
            myResult.setCode(1);
            myResult.setMsg("原密码错误！");
            return myResult;
        }
        entity.setPassword(user.getNewpassword());
        repository.save(entity);
        myResult.setCode(0);
        myResult.setMsg("修改成功！");
        myResult.setObj(entity);
        return myResult;
    }
}
