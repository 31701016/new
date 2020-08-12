package cn.edu.zucc.wyd.elasticsearch.repository;

import cn.edu.zucc.wyd.elasticsearch.form.MyResult;
import cn.edu.zucc.wyd.elasticsearch.form.User;

public interface UserService {
    MyResult login(User user);
    MyResult register(User user);
    MyResult changeinfo(User user);
    MyResult changepassword(User user);
}
