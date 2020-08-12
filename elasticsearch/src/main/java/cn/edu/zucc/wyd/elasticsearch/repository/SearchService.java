package cn.edu.zucc.wyd.elasticsearch.repository;


import cn.edu.zucc.wyd.elasticsearch.entity.NovelEntity;
import cn.edu.zucc.wyd.elasticsearch.entity.Novels;
import cn.edu.zucc.wyd.elasticsearch.form.PageResult;
import cn.edu.zucc.wyd.elasticsearch.form.SearchRequest;


public interface SearchService {
    PageResult<Novels> search(SearchRequest request);
    Novels buildNovels(NovelEntity novelEntity);
}
