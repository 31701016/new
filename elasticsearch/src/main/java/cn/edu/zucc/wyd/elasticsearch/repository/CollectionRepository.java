package cn.edu.zucc.wyd.elasticsearch.repository;

import cn.edu.zucc.wyd.elasticsearch.entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<CollectionEntity,Integer> {
    List<CollectionEntity> findAllByUserid(int userid);
    CollectionEntity findByUseridAndNovelid(int userid, int novelid);

}
