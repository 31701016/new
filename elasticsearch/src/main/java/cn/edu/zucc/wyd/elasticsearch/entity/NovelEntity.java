package cn.edu.zucc.wyd.elasticsearch.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="novels")
public class NovelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "novel_id")
    private int novelid;
    @Column(name = "novel_name")
    private String novelName;
    @Column(name = "novel_author")
    private String novelAuthor;
    @Column(name = "novel_type")
    private String novelType;
    @Column(name = "novel_click_num")
    private int novelClickNum;
    @Column(name = "novel_size")
    private String novelSize;
    @Column(name = "novel_file_type")
    private String novelFileType;
    @Column(name = "novel_update_time")
    private String novelUpdateTime;
    @Column(name = "novel_status")
    private String novelStatus;
    @Column(name = "novel_run_envir")
    private String novelRunEnvir;
    @Column(name = "novel_last_chapter")
    private String novelLastChapter;
    @Column(name = "novel_img_url")
    private String novelImgUrl;
    @Column(name = "novel_download_url")
    private String novelDownloadUrl;
    @Column(name = "novel_introduction")
    private String novelIntroduction;

    public int getNovelid() {
        return novelid;
    }

    public void setNovelid(int novelid) {
        this.novelid = novelid;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getNovelAuthor() {
        return novelAuthor;
    }

    public void setNovelAuthor(String novelAuthor) {
        this.novelAuthor = novelAuthor;
    }

    public String getNovelType() {
        return novelType;
    }

    public void setNovelType(String novelType) {
        this.novelType = novelType;
    }

    public int getNovelClickNum() {
        return novelClickNum;
    }

    public void setNovelClickNum(int novelClickNum) {
        this.novelClickNum = novelClickNum;
    }

    public String getNovelSize() {
        return novelSize;
    }

    public void setNovelSize(String novelSize) {
        this.novelSize = novelSize;
    }

    public String getNovelFileType() {
        return novelFileType;
    }

    public void setNovelFileType(String novelFileType) {
        this.novelFileType = novelFileType;
    }

    public String getNovelUpdateTime() {
        return novelUpdateTime;
    }

    public void setNovelUpdateTime(String novelUpdateTime) {
        this.novelUpdateTime = novelUpdateTime;
    }

    public String getNovelStatus() {
        return novelStatus;
    }

    public void setNovelStatus(String novelStatus) {
        this.novelStatus = novelStatus;
    }

    public String getNovelRunEnvir() {
        return novelRunEnvir;
    }

    public void setNovelRunEnvir(String novelRunEnvir) {
        this.novelRunEnvir = novelRunEnvir;
    }

    public String getNovelLastChapter() {
        return novelLastChapter;
    }

    public void setNovelLastChapter(String novelLastChapter) {
        this.novelLastChapter = novelLastChapter;
    }

    public String getNovelImgUrl() {
        return novelImgUrl;
    }

    public void setNovelImgUrl(String novelImgUrl) {
        this.novelImgUrl = novelImgUrl;
    }

    public String getNovelDownloadUrl() {
        return novelDownloadUrl;
    }

    public void setNovelDownloadUrl(String novelDownloadUrl) {
        this.novelDownloadUrl = novelDownloadUrl;
    }

    public String getNovelIntroduction() {
        return novelIntroduction;
    }

    public void setNovelIntroduction(String novelIntroduction) {
        this.novelIntroduction = novelIntroduction;
    }
}

