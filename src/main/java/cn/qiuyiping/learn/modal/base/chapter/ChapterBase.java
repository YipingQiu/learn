package cn.qiuyiping.learn.modal.base.chapter;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/2.
 */
@Entity
@Table(name = "chapter")
public class ChapterBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //章节id

    private String title;   //章节标题

    private Long parentId;  //父章节id

    private String level;   //章节层级

    @Column(name = "chapter_order")
    private int order;  //章节排序

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
