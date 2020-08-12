package cn.edu.zucc.wyd.elasticsearch.repository;

import cn.edu.zucc.wyd.elasticsearch.form.Novel;
import cn.edu.zucc.wyd.elasticsearch.form.MyResult;

public interface NovelService {
    MyResult loadnovel(Novel novel);

}
