package cn.edu.zucc.wyd.elasticsearch.repository;

import cn.edu.zucc.wyd.elasticsearch.entity.NovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface XcNovelsRepository extends JpaRepository<NovelEntity,Integer>, JpaSpecificationExecutor<NovelEntity> {
    NovelEntity findByNovelid(int novelid);

    //@Query("Select n From novels  n Where n.novelType=?1 ORDER BY n.novelClickNum LIMIT 0,10")
    List<NovelEntity> findByNovelTypeOrderByNovelClickNumDesc(String novelType);

    @Query(value="select * from novels where novel_type=? order by novel_click_num desc limit 10", nativeQuery = true)
    NovelEntity findNovel(String noveltype);

    @Query(value="select * from novels where novel_name like '%?%'", nativeQuery = true)
    List<NovelEntity> findNovellist(String name);
}
