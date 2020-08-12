package cn.edu.zucc.wyd.elasticsearch.service.impl;

import cn.edu.zucc.wyd.elasticsearch.entity.NovelEntity;
import cn.edu.zucc.wyd.elasticsearch.entity.Novels;
import cn.edu.zucc.wyd.elasticsearch.repository.NovelsRepository;
import cn.edu.zucc.wyd.elasticsearch.repository.XcNovelsRepository;
import cn.edu.zucc.wyd.elasticsearch.repository.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class SearchServiceImplTest {

    @Autowired
    private XcNovelsRepository xcNovelsRepository;

    @Autowired
    private NovelsRepository novelsRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private SearchService searchService;


    @Test
    public void testCreateIndex() {

        template.createIndex(Novels.class);
        template.putMapping(Novels.class);
    }

    @Test
    public void loadData() {
        int page = 1;
        int rows = 100;
        int size = 0;

        //查询spu信息
        do {

            Page<NovelEntity> result = xcNovelsRepository.findAll(PageRequest.of(page - 1, rows));
            List<NovelEntity> spuList = result.getContent();
            if (CollectionUtils.isEmpty(spuList)){
                break;
            }

            List<Novels> novelsList = spuList.stream()
                    .map(searchService::buildNovels).collect(Collectors.toList());
            //存入索引库
            novelsRepository.saveAll(novelsList);
            //翻页
            page++;
            size = spuList.size();
        } while (size == 100);

    }
}