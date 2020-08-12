package cn.edu.zucc.wyd.elasticsearch.repository;

import cn.edu.zucc.wyd.elasticsearch.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByLoginname(String loginname);
}
