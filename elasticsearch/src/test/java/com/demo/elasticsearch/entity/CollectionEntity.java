package com.demo.elasticsearch.entity;

import javax.persistence.*;

@Entity
@Table(name = "collection", schema = "search", catalog = "")
public class CollectionEntity {
    private int collectionId;
    private Integer userId;
    private Integer novelId;

    @Id
    @Column(name = "collection_id")
    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "novel_id")
    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionEntity that = (CollectionEntity) o;

        if (collectionId != that.collectionId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (novelId != null ? !novelId.equals(that.novelId) : that.novelId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collectionId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (novelId != null ? novelId.hashCode() : 0);
        return result;
    }
}
