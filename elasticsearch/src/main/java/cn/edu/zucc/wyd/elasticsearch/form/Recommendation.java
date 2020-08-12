package cn.edu.zucc.wyd.elasticsearch.form;

import cn.edu.zucc.wyd.elasticsearch.entity.NovelEntity;

public class Recommendation implements Comparable<Recommendation>{
    private NovelEntity novel;
    private int score;

    public NovelEntity getNovel() {
        return novel;
    }

    public void setNovel(NovelEntity novel) {
        this.novel = novel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Recommendation o) {
        return o.getScore() - this.getScore();
    }
}
