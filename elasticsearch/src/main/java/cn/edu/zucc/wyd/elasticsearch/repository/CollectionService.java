package cn.edu.zucc.wyd.elasticsearch.repository;

import cn.edu.zucc.wyd.elasticsearch.form.MyResult;
import cn.edu.zucc.wyd.elasticsearch.form.PageResult;
import cn.edu.zucc.wyd.elasticsearch.entity.NovelEntity;
import cn.edu.zucc.wyd.elasticsearch.form.Collection;
import cn.edu.zucc.wyd.elasticsearch.form.Recommendation;
import cn.edu.zucc.wyd.elasticsearch.form.SearchRequest;

public interface CollectionService {
    MyResult collect(Collection collection);
    PageResult<NovelEntity> loadCollections(SearchRequest request);
    PageResult<Recommendation> recommendation(SearchRequest request);
    MyResult beenCollected(Collection collection);
    MyResult cancelCollect(Collection collection);
}
