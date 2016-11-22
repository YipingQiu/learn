package cn.qiuyiping.learn.modal.base.chapter;

import org.hibernate.annotations.ColumnDefault;

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

    private int level;   //章节层级

    @Column(name = "chapter_order")
    private int order;  //章节排序

    @Column(columnDefinition = "INT default 0")
    private int deleted;    //是否删除，默认为0， 0 - 未删除， -1 - 已删除

    public ChapterBase(Long id) {
        this.id = id;
    }

    public ChapterBase() {

    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
