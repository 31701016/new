package cn.edu.zucc.wyd.elasticsearch.controller;

import cn.edu.zucc.wyd.elasticsearch.form.PageResult;
import cn.edu.zucc.wyd.elasticsearch.form.SearchRequest;
import cn.edu.zucc.wyd.elasticsearch.entity.Novels;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class SearchController {

    private ElasticsearchTemplate template;
    public SearchController(ElasticsearchTemplate template){
        this.template=template;
    }

    @GetMapping("search")
    public <T> PageResult search(SearchRequest request) {
//        查询功能，用了elasticsearch索引功能
        int page = request.getPage() - 1;
        int size = request.getSize();
        //创建查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withPageable(PageRequest.of(page, size));
        queryBuilder.withQuery(QueryBuilders.matchQuery("novelName", request.getKey()));

        AggregatedPage<Novels> result = template.queryForPage(queryBuilder.build(), Novels.class);
        long total = result.getTotalElements();
        Integer totalPages1 = result.getTotalPages();    //失效
        Long totalPages = total % size == 0 ? total / size : total / size + 1;
        List<Novels> novelsList = result.getContent();

        return new PageResult(total, totalPages, novelsList);
    }
}
