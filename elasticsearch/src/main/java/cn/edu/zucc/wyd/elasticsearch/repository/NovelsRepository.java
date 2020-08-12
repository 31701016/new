package cn.edu.zucc.wyd.elasticsearch.repository;

import cn.edu.zucc.wyd.elasticsearch.entity.Novels;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NovelsRepository extends ElasticsearchRepository<Novels,Integer> {
}
